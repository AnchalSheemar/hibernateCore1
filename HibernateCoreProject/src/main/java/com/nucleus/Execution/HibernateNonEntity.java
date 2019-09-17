package com.nucleus.Execution;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nucleus.entity.Student1;


public class HibernateNonEntity {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student1 stud=new Student1();
		stud.getSubCode();
stud.getSubName();
		stud.getAddress();
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
	}
