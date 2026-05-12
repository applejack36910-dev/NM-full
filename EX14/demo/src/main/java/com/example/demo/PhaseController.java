package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/phases")
public class PhaseController {

    @Autowired
    private PhaseRepository phaseRepo;

    @Autowired
    private ProjectRepository projectRepo;

    // Get all phases
    @GetMapping
    public List<Phase> getAll() {
        return phaseRepo.findAll();
    }

    // Get phase by id
    @GetMapping("/{id}")
    public Phase getOne(@PathVariable Long id) {
        return phaseRepo.findById(id).orElseThrow();
    }

    // Add phase to a project
    @PostMapping
    public Phase add(@RequestParam Long projectId,
                     @RequestParam String phaseName,
                     @RequestParam Integer effortDays,
                     @RequestParam Integer teamSize,
                     @RequestParam Double cost) {
        Project project = projectRepo.findById(projectId).orElseThrow();
        Phase phase = new Phase(null, phaseName, effortDays, teamSize, cost, project);
        return phaseRepo.save(phase);
    }

    // Delete phase
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        phaseRepo.deleteById(id);
        return "Phase " + id + " deleted!";
    }
}