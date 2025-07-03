package com.krish.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krish.dao.EmpDeptDao;
import com.krish.entity.Department;
import com.krish.entity.Employee;

public class TestEmpDeptDao {

	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new EmpDeptDao();
	}
	
	@Test
	public void testSaveDept() {
		Department dept = new Department(10, "Sales", "Pune");
		assertTrue(dao.saveDept(dept));
	}
	
	@Test
	public void testSaveEmp() {
		Employee emp = new Employee(102, "Sean", 1900);
		assertTrue(dao.saveEmp(emp, 10));
	}
	
	@Test
	public void testFindDept() {
		Department dept = dao.findDept(10);
		assertNotNull(dept);
		System.out.println(dept);
		dept.getEmps().forEach(System.out::println);
	}
	
	@Test
	public void testFindEmp() {
		Employee emp = dao.findEmp(101);
		assertNotNull(emp);
		System.out.println(emp);
		System.out.println(emp.getDept());
	}
	
	@Test
	public void testDeleteDept() {
		assertTrue(dao.deleteDept(10));
	}
}
