package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository repo;

    @GetMapping
    public List<Passenger> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Passenger add(@RequestBody Passenger passenger) {
        return repo.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody Passenger updated) {
        Passenger p = repo.findById(id).orElseThrow();
        p.setName(updated.getName());
        p.setEmail(updated.getEmail());
        p.setPhone(updated.getPhone());
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Passenger " + id + " deleted!";
    }
}