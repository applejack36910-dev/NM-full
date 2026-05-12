package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String email;
    private String showTime;
    private Integer seats;
    private Double totalAmount;
    private String status;  // CONFIRMED / CANCELLED

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;
}