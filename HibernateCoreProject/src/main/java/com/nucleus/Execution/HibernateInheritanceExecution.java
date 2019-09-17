package com.nucleus.Execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nucleus.inheritance.ContractEmployee;
//import com.nucleus.inheritance.ContractEmployee;
import com.nucleus.inheritance.Employee;
import com.nucleus.inheritance.RegularEmployee;

public class HibernateInheritanceExecution {

	
	public static void main(String[] args) 
	{
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		
		Employee employee=new Employee();

		
		
		RegularEmployee regularEmployee=new RegularEmployee();
		regularEmployee.setSalary(10000);
		regularEmployee.setName("nikita");
		
		
		ContractEmployee contractEmployee=new ContractEmployee();
		contractEmployee.setWorkDuration(8);
		contractEmployee.setWorkPay(10000);
		contractEmployee.setName("annu");
		
		
		
		
		session.persist(employee);
		session.persist(regularEmployee);
		session.persist(contractEmployee);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	
}
}