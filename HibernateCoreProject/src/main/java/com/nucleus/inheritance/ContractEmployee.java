package com.nucleus.inheritance;

import javax.persistence.Entity;

@Entity
public class ContractEmployee extends Employee{

	
	private int workDuration;
	private float workPay;
	public int getWorkDuration() {
		return workDuration;
	}
	public void setWorkDuration(int workDuration) {
		this.workDuration = workDuration;
	}
	public float getWorkPay() {
		return workPay;
	}
	public void setWorkPay(float workPay) {
		this.workPay = workPay;
	}
	
}
