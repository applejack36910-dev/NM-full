package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private PhaseRepository phaseRepo;

    // Get all projects
    @GetMapping
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    // Get project by id
    @GetMapping("/{id}")
    public Project getOne(@PathVariable Long id) {
        return projectRepo.findById(id).orElseThrow();
    }

    // Add project
    @PostMapping
    public Project add(@RequestBody Project project) {
        return projectRepo.save(project);
    }

    // Update project
    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project updated) {
        Project p = projectRepo.findById(id).orElseThrow();
        p.setProjectName(updated.getProjectName());
        p.setClientName(updated.getClientName());
        p.setStartDate(updated.getStartDate());
        p.setEndDate(updated.getEndDate());
        p.setStatus(updated.getStatus());
        p.setTotalBudget(updated.getTotalBudget());
        return projectRepo.save(p);
    }

    // Delete project
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        projectRepo.deleteById(id);
        return "Project " + id + " deleted!";
    }

    // Get all phases of a project
    @GetMapping("/{id}/phases")
    public List<Phase> getPhases(@PathVariable Long id) {
        return phaseRepo.findByProjectId(id);
    }

    // Get total effort of a project
    @GetMapping("/{id}/effort")
    public String totalEffort(@PathVariable Long id) {
        List<Phase> phases = phaseRepo.findByProjectId(id);
        int total = phases.stream()
                .mapToInt(Phase::getEffortDays)
                .sum();
        return "Total Effort : " + total + " person-days";
    }

    // Get total cost of a project
    @GetMapping("/{id}/cost")
    public String totalCost(@PathVariable Long id) {
        List<Phase> phases = phaseRepo.findByProjectId(id);
        double total = phases.stream()
                .mapToDouble(Phase::getCost)
                .sum();
        return "Total Cost : $" + total;
    }
}