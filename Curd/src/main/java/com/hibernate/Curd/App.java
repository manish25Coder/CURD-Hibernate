package com.hibernate.Curd;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.mapping.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = Hibernateutil.getSessionFactory();
    	
    	 Session session = factory.openSession();
    	 
    	 //Student create and save
    	 Student st=new Student();
    	 st.setName("Manish");
    	 st.setAddress("Mumbai");
    	 st.setEmail("manish@gmail.com");
    	 st.setCollegeName("Mumbai University");
    	 
    	 Student st2=new Student();
    	 st2.setName("Manisha");
    	 st2.setAddress("Kalyan");
    	 st2.setEmail("manisha@gmail.com");
    	 st2.setCollegeName("Pune University");
    	 
    	 Transaction tx =  session.beginTransaction();
    	 
    	 session.save(st);
    	 session.save(st2);
    	 
    	 tx.commit();
    	 
    	 System.out.println("Student Register Successfully");
    	 
    	 
    	 //read Data
    	 List<Student> list = session.createQuery("from Student",Student.class).list();
    	 
    	 list.forEach(e -> System.out.println(e));
    	 
    	 
//    	 //get by id
    	 
//    	 Student st = session.get(Student.class,1);
//    	 System.out.println(st);
//    	 
    	 
//    	 //Update Data
    	 
//    	 Student st = session.get(Student.class,1);
//    	 st.setName("manjeet");
//    	 st.setAddress("India");
//    	 st.setEmail("manjeet@gmail.com");
//    	 st.setCollegeName("UK University");
//    	 
//    	 Transaction tx = session.beginTransaction();
//    	 session.saveOrUpdate(st); 
//    	 tx.commit();
//    	 System.out.println("Data Updated Successfully");
    	 
    	 //Delete data
    	 
//    	 Student st = session.get(Student.class,1);
//    	 Transaction tx = session.beginTransaction();
//    	 session.delete(st);
//    	 tx.commit();
//    	 System.out.println("Data Deleted Successfully");
//    	 
    	 session.close();
    	 factory.close();
    }
}
