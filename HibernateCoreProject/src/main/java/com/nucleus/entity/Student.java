package com.nucleus.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nucleus.pojo.Address;

@Table(name="Student0010")//if you want to change table name.
@Entity
public class Student {
	
	@Column(name="stdid")//if you want to change column name.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//auto generated sequence vary from database to database.that's why we use Auto,which is applicable for all the databases.
 private int studentId;
	
	@Column(name="sname")
 private String studentName;
	
	

	//@JoinColumn(name="subjectCode")//this is used to change name of join column name.(newly derived column)
	
	//@OneToOne//this is unidirectional approach. if we made same OneToOne relationship with student in subject class.so,that is called bidirectional approach.
/*	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)//(mappedBy="student")
	private Subject subject;*/
	

	

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)//(mappedBy="student")//when one Student have multiple Subjects.
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Subject> subjects;
	
	
	
	
	
/*	@JoinTable(name="derived1",joinColumns=@JoinColumn(name="studentid"),
			inverseJoinColumns=@JoinColumn(name="subjectcode"))	
@ManyToMany	
private List<Subject> subjects;	
	*/
	
	
	
	
	
	
	
	
	
	
/*@Embedded
 Address address;
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}*///this is for one address per student.
	
	
	/*@ElementCollection
	private Collection<Address> lisOfAddresses = new ArrayList<>();
	
	
	public Collection<Address> getLisOfAddresses() {
	return lisOfAddresses;
	}
	public void setLisOfAddresses(Collection<Address> lisOfAddresses) {
	this.lisOfAddresses = lisOfAddresses;
	}*/
	
	
	
	
	
	
	

public List<Subject> getSubjects() {
	return subjects;
}

public void setSubjects(List<Subject> subjects) {
	this.subjects = subjects;
}
/*
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getStudentId() {
		return studentId;
	}*/
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}

}
