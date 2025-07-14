package com.krish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krish.entity.Ticket;
import com.krish.repo.TicketRepository;
import com.krish.util.InvalidTicketException;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repo;
	
	@Override
	public Ticket bookTicket(Ticket tkt) {
		return repo.save(tkt);
	}

	@Override
	public Ticket findByPnr(long pnr) {
		return repo.findById(pnr).orElseThrow(() -> new InvalidTicketException("No ticket with PNR: " + pnr));
	}

}
