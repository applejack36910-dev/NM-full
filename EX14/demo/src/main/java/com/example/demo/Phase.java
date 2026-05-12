package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phaseName;
    private Integer effortDays;
    private Integer teamSize;
    private Double cost;

    @ManyToOne
    private Project project;
}