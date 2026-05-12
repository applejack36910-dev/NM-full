package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository repo;

    // Get all flights
    @GetMapping
    public List<Flight> getAll() {
        return repo.findAll();
    }

    // Get flight by id
    @GetMapping("/{id}")
    public Flight getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Search flights by source and destination
    @GetMapping("/search")
    public List<Flight> search(@RequestParam String source,
                               @RequestParam String destination) {
        return repo.findBySourceAndDestination(source, destination);
    }

    // Search flights by fare
    @GetMapping("/fare")
    public List<Flight> byFare(@RequestParam Double max) {
        return repo.findByFareLessThan(max);
    }

    // Add flight
    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return repo.save(flight);
    }

    // Update flight
    @PutMapping("/{id}")
    public Flight update(@PathVariable Long id, @RequestBody Flight updated) {
        Flight f = repo.findById(id).orElseThrow();
        f.setFlightNumber(updated.getFlightNumber());
        f.setSource(updated.getSource());
        f.setDestination(updated.getDestination());
        f.setDepartureTime(updated.getDepartureTime());
        f.setFare(updated.getFare());
        f.setAvailableSeats(updated.getAvailableSeats());
        return repo.save(f);
    }

    // Delete flight
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Flight " + id + " deleted!";
    }
}