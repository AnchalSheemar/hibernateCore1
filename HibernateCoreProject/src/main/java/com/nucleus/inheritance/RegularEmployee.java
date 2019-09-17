package com.nucleus.inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegularEmployee extends Employee{
	

	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
