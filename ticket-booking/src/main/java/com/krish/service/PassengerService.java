package com.krish.service;

import com.krish.entity.Passenger;
import com.krish.entity.Ticket;

public interface PassengerService {

	Ticket showTicket(int pid);
	
	Passenger addToTicket(Passenger p, long pnr);
	
}
