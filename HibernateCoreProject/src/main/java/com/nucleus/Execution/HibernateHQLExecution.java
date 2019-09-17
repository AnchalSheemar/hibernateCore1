package com.nucleus.Execution;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nucleus.entity.Subject;

public class HibernateHQLExecution {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		/*Subject subject=new Subject();
		subject.setSubCode(1001);
		subject.setSubName("English");		
		Subject subject2=new Subject();
		subject2.setSubCode(1002);
		subject2.setSubName("Maths");
		session.persist(subject);
		session.persist(subject2);*/
		
		//All Records
		Query query1=session.createQuery("from Subject");
		System.out.println(query1.list());
		
		//Named Parameter
		/*Query query2=session.createQuery("from Subject where subName=:subName");
		query2.setParameter("subName", "English");
		System.out.println(query2.list());*/
		
		//Positional Parameter
		/*Query query3=session.createQuery("from Subject where subName=?");
		query3.setParameter(0, "Maths");
		System.out.println(query3.list());*/
		
		/*Query query4=session.createQuery("select max(subCode) from Subject");		
		System.out.println(query4.list());*/
		
		
		/*Query query5=session.createQuery("select subCode from Subject");
		List<Integer> subCodes=query5.list();
		for(int subCode:subCodes)
		{
			
			System.out.println(subCode);
		}*/
		
		
		/*Query query6=session.createQuery("from Subject");
		query6.setFirstResult(1);
		query6.setMaxResults(2);*/
		
		
		/*Query query7=session.getNamedQuery("getAllSubjects");		
		System.out.println(query7.list());*/
		
		/*SQLQuery query8=session.createSQLQuery("select * from Subject");
		query8.addEntity(Subject.class);
		System.out.println(query8.list());*/
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}
	}


