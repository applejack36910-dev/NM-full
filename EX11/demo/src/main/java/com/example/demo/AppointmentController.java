package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repo;

    @Autowired
    private DoctorRepository doctorRepo;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAll() {
        return repo.findAll();
    }

    // Get appointment by id
    @GetMapping("/{id}")
    public Appointment getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // Get appointments by doctor
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> byDoctor(@PathVariable Long doctorId) {
        return repo.findByDoctorId(doctorId);
    }

    // Get appointments by patient name
    @GetMapping("/patient/{name}")
    public List<Appointment> byPatient(@PathVariable String name) {
        return repo.findByPatientName(name);
    }

    // Book appointment
    @PostMapping
    public Appointment book(@RequestParam Long doctorId,
                            @RequestParam String patientName,
                            @RequestParam String date) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        Appointment a = new Appointment(null, patientName, date, "SCHEDULED", doctor);
        return repo.save(a);
    }

    // Cancel appointment
    @PutMapping("/{id}/cancel")
    public Appointment cancel(@PathVariable Long id) {
        Appointment a = repo.findById(id).orElseThrow();
        a.setStatus("CANCELLED");
        return repo.save(a);
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Appointment " + id + " deleted!";
    }
}