package com.krish.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.krish.entity.Customer;

public class CustomerDao {
	private EntityManagerFactory factory;
	
	public CustomerDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Customer c) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			em.persist(c);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}
	
	public Customer find(int custId) {
		EntityManager em = factory.createEntityManager();
		return em.find(Customer.class, custId);
	}
	
	public List<Customer> list() {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("FROM Customer");
		return query.getResultList();
	}
	
	public boolean delete(int custId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Customer c1 = em.find(Customer.class, custId);
			em.remove(c1);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}
	
	public List<Customer> ageRange(int min, int max) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("FROM Customer WHERE age between :min and :max");
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList();
	}
}
