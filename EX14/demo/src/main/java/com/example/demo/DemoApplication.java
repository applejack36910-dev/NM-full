package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(ProjectRepository projects,
                           PhaseRepository phases) {
        return args -> {
            Project p1 = projects.save(new Project(null, "Banking App",  "HDFC",  "2024-01-01", "2024-06-01", "ACTIVE",    500000.00));
            Project p2 = projects.save(new Project(null, "HR System",    "Infosys","2024-02-01", "2024-08-01", "ACTIVE",    300000.00));

            phases.save(new Phase(null, "Design",      10, 3, 30000.00,  p1));
            phases.save(new Phase(null, "Development", 30, 5, 150000.00, p1));
            phases.save(new Phase(null, "Testing",     10, 2, 20000.00,  p1));

            phases.save(new Phase(null, "Design",      8,  2, 20000.00,  p2));
            phases.save(new Phase(null, "Development", 20, 4, 100000.00, p2));
            phases.save(new Phase(null, "Testing",     7,  2, 15000.00,  p2));
        };
    }
}

/*Projects
GET  /projects
GET  /projects/1
GET  /projects/1/phases       ← all phases of project 1
GET  /projects/1/effort       ← total effort in person-days
GET  /projects/1/cost         ← total cost of project

POST /projects
→ { "projectName":"Payroll", "clientName":"TCS",
    "startDate":"2024-03-01", "endDate":"2024-09-01",
    "status":"ACTIVE", "totalBudget":400000.00 }

PUT    /projects/1
DELETE /projects/1
Phases
GET  /phases
GET  /phases/1

POST /phases?projectId=1&phaseName=Design&effortDays=10&teamSize=3&cost=30000

DELETE /phases/1*/
