package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findBySourceAndDestination(String source, String destination);
    List<Flight> findByFareLessThan(Double fare);
}