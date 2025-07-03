package com.krish.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krish.dao.CustomerDao;
import com.krish.entity.Customer;

public class TestCustomerDao {
	private static CustomerDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c1 = new Customer(123, "Mike", 43, "4343944834");
		assertTrue(dao.save(c1));
	}
	
	@Test
	public void testFind() {
		Customer c1 = dao.find(123);
		assertNotNull(c1);
		System.out.println(c1);
	}
	
	@Test
	public void testList() {
		List<Customer> customers = dao.list();
		assertEquals(customers.size(), 1);
	}
	
	
}
