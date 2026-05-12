package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository repo;

    @Autowired
    private FlightRepository flightRepo;

    @Autowired
    private PassengerRepository passengerRepo;

    // Get all bookings
    @GetMapping
    public List<Booking> getAll() {
        return repo.findAll();
    }

    // Get bookings by passenger
    @GetMapping("/passenger/{id}")
    public List<Booking> byPassenger(@PathVariable Long id) {
        return repo.findByPassengerId(id);
    }

    // Get bookings by flight
    @GetMapping("/flight/{id}")
    public List<Booking> byFlight(@PathVariable Long id) {
        return repo.findByFlightId(id);
    }

    // Create booking
    @PostMapping
    public Booking book(@RequestParam Long flightId,
                        @RequestParam Long passengerId) {
        Flight flight = flightRepo.findById(flightId).orElseThrow();
        Passenger passenger = passengerRepo.findById(passengerId).orElseThrow();
        Booking booking = new Booking(null, flight, passenger, 
                          java.time.LocalDate.now().toString(), "CONFIRMED");
        return repo.save(booking);
    }

    // Cancel booking
    @PutMapping("/{id}/cancel")
    public Booking cancel(@PathVariable Long id) {
        Booking b = repo.findById(id).orElseThrow();
        b.setStatus("CANCELLED");
        return repo.save(b);
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Booking " + id + " deleted!";
    }
}
