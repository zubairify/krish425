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

import com.krish.entity.Ticket;
import com.krish.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService service;
	
	@PostMapping(value = "/book", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket t) {
		Ticket tkt = service.bookTicket(t);
		return new ResponseEntity<Ticket>(tkt, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{pnr}", produces = "application/json")
	public ResponseEntity<Ticket> findByPnr(@PathVariable long pnr) {
		Ticket tkt = service.findByPnr(pnr);
		return new ResponseEntity<Ticket>(tkt, HttpStatus.FOUND);
	}
}
