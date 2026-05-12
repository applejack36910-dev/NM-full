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
    CommandLineRunner seed(TrainRepository trains,
                           BookingRepository bookings) {
        return args -> {
            Train t1 = trains.save(new Train(null, "IR101", "Chennai",   "Mumbai",    "06:00", 1200.00, 100));
            Train t2 = trains.save(new Train(null, "IR102", "Mumbai",    "Delhi",     "08:00", 1500.00, 80));
            Train t3 = trains.save(new Train(null, "IR103", "Delhi",     "Bangalore", "10:00", 1800.00, 60));
            Train t4 = trains.save(new Train(null, "IR104", "Chennai",   "Delhi",     "12:00", 2000.00, 50));

            bookings.save(new Booking(null, "John",  "2024-02-01", "CONFIRMED", t1));
            bookings.save(new Booking(null, "Priya", "2024-02-02", "CONFIRMED", t1));
            bookings.save(new Booking(null, "Rahul", "2024-02-03", "CONFIRMED", t2));
            bookings.save(new Booking(null, "Sneha", "2024-02-04", "CONFIRMED", t3));
        };
    }
}