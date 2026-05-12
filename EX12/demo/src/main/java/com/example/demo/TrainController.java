package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainRepository repo;

    // Get all trains
    @GetMapping
    public List<Train> getAll() {
        return repo.findAll();
    }

    // Get train by id
    @GetMapping("/{id}")
    public Train getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Search by source and destination
    @GetMapping("/search")
    public List<Train> search(@RequestParam String source,
                              @RequestParam String destination) {
        return repo.findBySourceAndDestination(source, destination);
    }

    // Add train
    @PostMapping
    public Train add(@RequestBody Train train) {
        return repo.save(train);
    }

    // Update train
    @PutMapping("/{id}")
    public Train update(@PathVariable Long id, @RequestBody Train updated) {
        Train t = repo.findById(id).orElseThrow();
        t.setTrainNumber(updated.getTrainNumber());
        t.setSource(updated.getSource());
        t.setDestination(updated.getDestination());
        t.setDepartureTime(updated.getDepartureTime());
        t.setFare(updated.getFare());
        t.setAvailableSeats(updated.getAvailableSeats());
        return repo.save(t);
    }

    // Delete train
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Train " + id + " deleted!";
    }
}