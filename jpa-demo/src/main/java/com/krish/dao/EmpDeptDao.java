package com.krish.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.krish.entity.Department;
import com.krish.entity.Employee;

public class EmpDeptDao {

	private EntityManagerFactory emf;
	
	public EmpDeptDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean saveDept(Department dept) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(dept);
		txn.commit();
		return true;
	}
	
	public boolean saveEmp(Employee emp, int deptNo) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department dept = em.find(Department.class, deptNo);
		emp.setDept(dept);	// Setting department for an employee
		em.persist(emp);
		txn.commit();
		return true;
	}
	
	public Department findDept(int deptNo) {
		EntityManager em = emf.createEntityManager();
		return em.find(Department.class, deptNo);
	}
	
	public Employee findEmp(int empNo) {
		EntityManager em = emf.createEntityManager();
		return em.find(Employee.class, empNo);
	}
	
	public boolean deleteDept(int deptNo) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		Department dept = em.find(Department.class, deptNo);
		em.remove(dept);
		txn.commit();
		return true;
	}
}
