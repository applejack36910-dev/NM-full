package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;

    private String bookingDate;
    private String status;  // CONFIRMED / CANCELLED
}