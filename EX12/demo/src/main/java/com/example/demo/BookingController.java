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
    private TrainRepository trainRepo;

    // Get all bookings
    @GetMapping
    public List<Booking> getAll() {
        return repo.findAll();
    }

    // Get booking by id
    @GetMapping("/{id}")
    public Booking getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Get bookings by train
    @GetMapping("/train/{trainId}")
    public List<Booking> byTrain(@PathVariable Long trainId) {
        return repo.findByTrainId(trainId);
    }

    // Get bookings by passenger
    @GetMapping("/passenger/{name}")
    public List<Booking> byPassenger(@PathVariable String name) {
        return repo.findByPassengerName(name);
    }

    // Book a ticket
    @PostMapping
    public Booking book(@RequestParam Long trainId,
                        @RequestParam String passengerName,
                        @RequestParam String date) {
        Train train = trainRepo.findById(trainId).orElseThrow();
        Booking b = new Booking(null, passengerName, date, "CONFIRMED", train);
        return repo.save(b);
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