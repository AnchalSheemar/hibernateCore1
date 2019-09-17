package com.nucleus.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name="Subject0010")
@Entity
public class Subject {

	@Id
	private int subCode;
	private String subName;
	
/*	@JoinColumn(name="subject001")
	@OneToOne//this is Bidirectiomnal approach.
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}*/
	
	
	
	
	
	@ManyToOne
	private Student student;
	
	
	
public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	/*	
	@JoinTable(name="derived2"+ "",joinColumns=@JoinColumn(name="studentid"),
			inverseJoinColumns=@JoinColumn(name="subjectcode"))
	@ManyToMany
	private List<Student> students;
	
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}*/
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
	
	
	
}
