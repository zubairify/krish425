package com.krish.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust")
public class Customer {
	@Id
	@Column(name = "cust_id")
	private int custId;
	@Column(length = 25, name = "cust_name")
	private String custName;
	private int age;
	@Column(length = 12)
	private String mobile;
	
	public Customer() {
	}

	public Customer(int custId, String custName, int age, String mobile) {
		this.custId = custId;
		this.custName = custName;
		this.age = age;
		this.mobile = mobile;
	}

	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", age=" + age + ", mobile=" + mobile + "]";
	}
}
