package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository repo;

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private TheatreRepository theatreRepo;

    @GetMapping
    public List<Ticket> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping("/customer/{name}")
    public List<Ticket> byCustomer(@PathVariable String name) {
        return repo.findByCustomerName(name);
    }

    @GetMapping("/movie/{movieId}")
    public List<Ticket> byMovie(@PathVariable Long movieId) {
        return repo.findByMovieId(movieId);
    }

    @GetMapping("/theatre/{theatreId}")
    public List<Ticket> byTheatre(@PathVariable Long theatreId) {
        return repo.findByTheatreId(theatreId);
    }

    // Book ticket
    @PostMapping
    public Ticket book(@RequestParam Long movieId,
                       @RequestParam Long theatreId,
                       @RequestParam String customerName,
                       @RequestParam String email,
                       @RequestParam String showTime,
                       @RequestParam Integer seats,
                       @RequestParam Double totalAmount) {
        Movie movie     = movieRepo.findById(movieId).orElseThrow();
        Theatre theatre = theatreRepo.findById(theatreId).orElseThrow();
        Ticket ticket   = new Ticket(null, customerName, email,
                          showTime, seats, totalAmount,
                          "CONFIRMED", movie, theatre);
        return repo.save(ticket);
    }

    // Cancel ticket
    @PutMapping("/{id}/cancel")
    public Ticket cancel(@PathVariable Long id) {
        Ticket t = repo.findById(id).orElseThrow();
        t.setStatus("CANCELLED");
        return repo.save(t);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Ticket " + id + " deleted!";
    }
}