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
   CommandLineRunner seed(DoctorRepository doctors,
						  AppointmentRepository appointments) {
	   return args -> {
		   Doctor d1 = doctors.save(new Doctor(null, "Dr. Smith",  "Cardiology",  "9876543210"));
		   Doctor d2 = doctors.save(new Doctor(null, "Dr. Priya",  "Neurology",   "9876543211"));
		   Doctor d3 = doctors.save(new Doctor(null, "Dr. Rahul",  "Orthopedics", "9876543212"));
		   Doctor d4 = doctors.save(new Doctor(null, "Dr. Anjali", "Pediatrics",  "9876543213"));
   
		   appointments.save(new Appointment(null, "John",  "2024-02-01", "SCHEDULED", d1));
		   appointments.save(new Appointment(null, "Priya", "2024-02-02", "SCHEDULED", d1));
		   appointments.save(new Appointment(null, "Rahul", "2024-02-03", "SCHEDULED", d2));
		   appointments.save(new Appointment(null, "Sneha", "2024-02-04", "SCHEDULED", d3));
	   };
   }
}