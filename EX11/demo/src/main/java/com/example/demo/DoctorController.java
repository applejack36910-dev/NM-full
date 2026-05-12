package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repo;

    // Get all doctors
    @GetMapping
    public List<Doctor> getAll() {
        return repo.findAll();
    }

    // Get doctor by id
    @GetMapping("/{id}")
    public Doctor getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Get doctors by specialization
    @GetMapping("/specialization/{spec}")
    public List<Doctor> bySpec(@PathVariable String spec) {
        return repo.findBySpecialization(spec);
    }

    // Add doctor
    @PostMapping
    public Doctor add(@RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

    // Update doctor
    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor updated) {
        Doctor d = repo.findById(id).orElseThrow();
        d.setName(updated.getName());
        d.setSpecialization(updated.getSpecialization());
        d.setPhone(updated.getPhone());
        return repo.save(d);
    }

    // Delete doctor
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Doctor " + id + " deleted!";
    }
}