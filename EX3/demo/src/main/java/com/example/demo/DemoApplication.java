package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import main.java.com.example.demo.Appointment;
import main.java.com.example.demo.AppointmentRepository;
import main.java.com.example.demo.Doctor;
import main.java.com.example.demo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    Engine engine;

    @Autowired
    public DemoApplication(Engine engine) {
        this.engine = engine;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/start")
    public String start() {
        return engine.start();
    }
}