package com.nucleus.model;

public class UserClass {
	
private  double principalAmount;
	private double  rateOfInterest;
	 private double tenure;
	 private double month;
	public double getMonth() {
		return month;
	}
	public void setMonth(double month) {
		this.month = month;
	}
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public double getTenure() {
		return tenure;
	}
	public void setTenure(double tenure) {
		this.tenure = tenure;
	}
}
