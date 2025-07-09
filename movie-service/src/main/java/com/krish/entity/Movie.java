package com.krish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@Column(name = "mov_id")
	private int movId;
	@Column(length = 20)
	private String title;
	@Column(length = 20)
	private String genre;
	private double rating;
	
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
