package com.krish.service;

import com.krish.entity.Ticket;

public interface TicketService {

	Ticket bookTicket(Ticket tkt);
	
	Ticket findByPnr(long pnr);
	
}
