package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository repo;

    @GetMapping
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Movie getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> byGenre(@PathVariable String genre) {
        return repo.findByGenre(genre);
    }

    @GetMapping("/language/{language}")
    public List<Movie> byLanguage(@PathVariable String language) {
        return repo.findByLanguage(language);
    }

    @GetMapping("/rating")
    public List<Movie> byRating(@RequestParam Double min) {
        return repo.findByRatingGreaterThan(min);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return repo.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie updated) {
        Movie m = repo.findById(id).orElseThrow();
        m.setTitle(updated.getTitle());
        m.setGenre(updated.getGenre());
        m.setLanguage(updated.getLanguage());
        m.setDirector(updated.getDirector());
        m.setDuration(updated.getDuration());
        m.setRating(updated.getRating());
        m.setReleaseDate(updated.getReleaseDate());
        return repo.save(m);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Movie " + id + " deleted!";
    }
}