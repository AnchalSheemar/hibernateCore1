package com.nucleus.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.nucleus.pojo.Address;
@Entity
public class Student1 {
	@Id
	private int subCode;
	private String subName;
	@Embedded
	private Address address;
	public int getSubCode() {
		return subCode;
	}
	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
