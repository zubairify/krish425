package com.krish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krish.entity.Passenger;
import com.krish.entity.Ticket;
import com.krish.repo.PassengerRepository;
import com.krish.util.InvalidPassengerException;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository repo;
	
	@Autowired
	private TicketService tktService;
	
	@Override
	public Ticket showTicket(int pid) {
		Passenger p = repo.findById(pid).orElseThrow(() -> new InvalidPassengerException("Passenger not found with ID: " + pid));
		return p.getTicket();
	}

	@Override
	public Passenger addToTicket(Passenger p, long pnr) {
		Ticket tkt = tktService.findByPnr(pnr);
		p.setTicket(tkt);
		tkt.getPassengers().add(p);
		repo.save(p);
		return p;
	}

}
