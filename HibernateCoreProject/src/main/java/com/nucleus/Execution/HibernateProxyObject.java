package com.nucleus.Execution;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nucleus.entity.Student;


public class HibernateProxyObject {

	
	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();		
	/*	
		Student class varibles are level-1 data.
		subject class variables are level-2 data.*/
	
       Student student=(Student)session.get(Student.class, 1);
		//Student student=(Student)session.load(Student.class, 1);
		//System.out.println(student.getStudentName());		
		//System.out.println(student.getSubjects().get(0).getSubName());
		session.close();		
		Session session2=sessionFactory.openSession();
		System.out.println(student.getStudentName());
		System.out.println(student.getSubjects().get(0).getSubName());
		session2.close();
		sessionFactory.close();

	}
}

/*LAZY=load data on demand.but by default it retrieves data of level-1.
EAGER=it loads all the data.

get=it retrieves all the data.
load=it retrieves data on demand.*/


/*(LAZY+get)if we make fetch type =LAZY by default it will retrieve object of level-1 whether we call it or not.
(LAZY+load)=it retrives objects only on demand.Even level-1 objects  retreive on demand too.
(EAGER+get)=retrieve objects of all level.
(EAGER+load)=Retrieve objects on demand only.*/