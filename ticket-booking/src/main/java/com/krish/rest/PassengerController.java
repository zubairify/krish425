package com.krish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krish.entity.Passenger;
import com.krish.entity.Ticket;
import com.krish.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService service;
	
	@PostMapping(value = "/add/{pnr}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Passenger> addToTicket(@RequestBody Passenger p, @PathVariable long pnr) {
		Passenger ps = service.addToTicket(p, pnr);
		return new ResponseEntity<Passenger>(ps, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{pid}", produces = "application/json")
	public ResponseEntity<Ticket> showTicket(@PathVariable int pid) {
		Ticket tkt = service.showTicket(pid);
		return new ResponseEntity<Ticket>(tkt, HttpStatus.FOUND);
	}
}
