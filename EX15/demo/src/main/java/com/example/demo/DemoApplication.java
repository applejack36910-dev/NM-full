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
    CommandLineRunner seed(MovieRepository movies,
                           TheatreRepository theatres,
                           TicketRepository tickets) {
        return args -> {
            Movie m1 = movies.save(new Movie(null, "Interstellar", "Sci-Fi",  "English", "Nolan",   169, 8.6, "2014-11-07"));
            Movie m2 = movies.save(new Movie(null, "RRR",          "Action",  "Telugu",  "Rajamouli",187, 8.0, "2022-03-25"));
            Movie m3 = movies.save(new Movie(null, "KGF",          "Action",  "Kannada", "Prashanth",168, 8.2, "2022-04-14"));

            Theatre t1 = theatres.save(new Theatre(null, "PVR",   "Chennai", 200, 150));
            Theatre t2 = theatres.save(new Theatre(null, "INOX",  "Mumbai",  300, 200));
            Theatre t3 = theatres.save(new Theatre(null, "Sathyam","Chennai",250, 100));

            tickets.save(new Ticket(null, "John",  "john@gmail.com",  "10:00 AM", 2, 500.00,  "CONFIRMED", m1, t1));
            tickets.save(new Ticket(null, "Priya", "priya@gmail.com", "01:00 PM", 3, 750.00,  "CONFIRMED", m2, t2));
            tickets.save(new Ticket(null, "Rahul", "rahul@gmail.com", "04:00 PM", 2, 600.00,  "CONFIRMED", m3, t3));
        };
    }
}