package com.krish.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private int pid;
	@Column(length = 30)
	private String name;
	private int age;
	@Column(length = 10)
	private String gender;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pnr")
	private Ticket ticket;

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
