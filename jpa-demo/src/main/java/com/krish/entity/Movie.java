package com.krish.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	private int movId;
	@Column(length = 20)
	private String title;
	
	@ManyToMany
	@JoinTable(name = "shows",
		joinColumns = {@JoinColumn(name = "movId")},
		inverseJoinColumns = {@JoinColumn(name = "mpexId")}
	)
	Set<Multiplex> multiplexes = new HashSet<>();

	// Getters and Setters
	public int getMovId() {
		return movId;
	}
	public void setMovId(int movId) {
		this.movId = movId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Multiplex> getMultiplexes() {
		return multiplexes;
	}
	public void setMultiplexes(Set<Multiplex> multiplexes) {
		this.multiplexes = multiplexes;
	}
}
