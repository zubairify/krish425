package com.krish.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {
	@Id
	private long pnr;
	@Column(length = 20)
	private String source;
	@Column(length = 20)
	private String destination;
	private LocalDate schedule;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
	List<Passenger> passengers;

	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDate schedule) {
		this.schedule = schedule;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
