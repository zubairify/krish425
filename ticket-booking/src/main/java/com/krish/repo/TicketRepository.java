package com.krish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
