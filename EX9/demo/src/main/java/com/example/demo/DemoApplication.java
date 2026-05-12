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
    CommandLineRunner seed(FlightRepository flights,
                           PassengerRepository passengers) {
        return args -> {
            flights.save(new Flight(null, "IG101", "Chennai",   "Mumbai",    "08:00", 4500.00, 50));
            flights.save(new Flight(null, "IG102", "Mumbai",    "Delhi",     "10:00", 5500.00, 30));
            flights.save(new Flight(null, "IG103", "Delhi",     "Bangalore", "12:00", 3500.00, 40));
            flights.save(new Flight(null, "IG104", "Chennai",   "Delhi",     "14:00", 6000.00, 20));

            passengers.save(new Passenger(null, "Rahul",  "rahul@gmail.com",  "9876543210"));
            passengers.save(new Passenger(null, "Priya",  "priya@gmail.com",  "9876543211"));
            passengers.save(new Passenger(null, "Arjun",  "arjun@gmail.com",  "9876543212"));
        };
    }
}