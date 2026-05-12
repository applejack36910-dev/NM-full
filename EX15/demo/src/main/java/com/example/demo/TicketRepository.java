package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCustomerName(String customerName);
    List<Ticket> findByMovieId(Long movieId);
    List<Ticket> findByTheatreId(Long theatreId);
}