package com.hibernate.Curd;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Hibernateutil {

	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try 
			{
				Configuration configuration=new Configuration();
				Properties properties=new Properties();
				properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/manish_hib");
				properties.put(Environment.USER,"root");
				properties.put(Environment.PASS, "root");
				properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				
				properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				properties.put(Environment.SHOW_SQL, "true");
				
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(Student.class);
				
				ServiceRegistry serviceregistery=new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).build();
				
				sessionFactory=configuration.buildSessionFactory(serviceregistery);//get object
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		
		
		
		return sessionFactory;
		
	}

}
	

