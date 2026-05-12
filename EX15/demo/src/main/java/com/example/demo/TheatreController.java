package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreRepository repo;

    @GetMapping
    public List<Theatre> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Theatre getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping("/location/{location}")
    public List<Theatre> byLocation(@PathVariable String location) {
        return repo.findByLocation(location);
    }

    @PostMapping
    public Theatre add(@RequestBody Theatre theatre) {
        return repo.save(theatre);
    }

    @PutMapping("/{id}")
    public Theatre update(@PathVariable Long id, @RequestBody Theatre updated) {
        Theatre t = repo.findById(id).orElseThrow();
        t.setName(updated.getName());
        t.setLocation(updated.getLocation());
        t.setTotalSeats(updated.getTotalSeats());
        t.setAvailableSeats(updated.getAvailableSeats());
        return repo.save(t);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Theatre " + id + " deleted!";
    }
}