package com.nucleus.Execution;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nucleus.entity.Student;
import com.nucleus.entity.Subject;

public class EntityToEntityMain {

	public static void main(String[] args) 
		{
			Configuration configuration=new Configuration();
			configuration.configure();
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();

			
			 
			
	/*	.........................	This is for one to one relationship...........................................*/
		/*	
			Subject subject=new Subject();
			Student student =new Student();
			subject.setSubCode(10);
			subject.setSubName("english");
	        subject.setStudent(student);
			
			student.setStudentName("anchal");
			student.setSubject(subject);
			
			
            session.persist(subject);
			session.persist(student);*/
	
			
			
		/*...........................	this is for OneToMany Relationship..................................*/
		
			
			
			List<Subject> subjects=new ArrayList<>();
			Student student =new Student();
			
			Subject subject=new Subject();
			subject.setSubCode(10);
			subject.setSubName("english");
			subject.setStudent(student);
			
		
			Subject subject1=new Subject();
			subject1.setSubCode(20);
			subject1.setSubName("history");
			subject1.setStudent(student);
			
			
			subjects.add(subject);
			subjects.add(subject1);
	
			student.setStudentName("anchal");
			student.setSubjects(subjects);
		
			  session.persist(subject);
			  session.persist(subject1);
			  session.persist(student);
			  
				
			
			/*...........................	this is for ManyToMany Relationship..................................*/
			
			
		/*	List<Subject> subjects=new ArrayList<>();
			List<Student> students=new ArrayList<>();
			
			
			Subject subject=new Subject();
			subject.setSubCode(10);
			subject.setSubName("english");
			subject.setStudents(students);
			
			Subject subject1=new Subject();
			subject1.setSubCode(20);
			subject1.setSubName("maths");
			subject1.setStudents(students);
		
			subjects.add(subject);
			subjects.add(subject1);
			
			
			
			
			Student student =new Student();
			student.setStudentName("anchal");
			student.setSubjects(subjects);
			
		
			Student student1 =new Student();
			student1.setStudentName("nikita");
			student1.setSubjects(subjects);
			
	       students.add(student);
	       students.add(student1);
			
			session.persist(subject);
			session.persist(subject1);
			session.persist(student);
			session.persist(student1);*/
			
			
			
			
				transaction.commit();
				session.close();
				sessionFactory.close();
			
	}

}
