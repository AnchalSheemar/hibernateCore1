



package com.nucleus.Execution;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nucleus.entity.Student;
import com.nucleus.entity.Subject;
import com.nucleus.pojo.Address;

public class HibernateMain {
public static void main(String[] args) 
{
Configuration configuration=new Configuration();
configuration.configure();
SessionFactory sessionFactory=configuration.buildSessionFactory();
Session session=sessionFactory.openSession();
Transaction transaction=session.beginTransaction();
/*Student student=new Student();
//student.setStudentId(2);
//student.setStudentName("aman");
//session.persist(student);
//System.out.println("saved");// this is for insert values in table.
*/
/*Student student=(Student)session.get(Student.class, 2);
System.out.println(student.getStudentId()+" "+student.getStudentName());*///this is for retrieve data.


/*
Student student=new Student();
student.setStudentId(2);
session.delete(student);*///this is for delete.





/*Student student=new Student();

student.setStudentId(2);
student.setStudentName("nikita");
session.saveOrUpdate(student);*/







/*
Address address=new Address();
address.setCity("noida");
address.setCountry("india");

Student student=new Student();
student.setStudentName("anchal");
student.setAddress(address);
session.persist(student);*/



/*Student student=new Student();


student.setStudentName("pinkki");
Address address1=new Address();

address1.setCity("gzb");
address1.setCountry("india");



Address address2=new Address();
address2.setCity("noida");
address2.setCountry("india");


ArrayList<Address> list=new ArrayList<>();
list.add(address1);
list.add(address2);

student.setLisOfAddresses(list);
 session.persist(student);*/





}
}
