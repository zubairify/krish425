package com.krish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
