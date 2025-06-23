package com.cdac.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		//1. Create singleton instance of SF (SessionFactory) from Configuration
		//1.1 create new empty config instance 
		//1.2 load config -  Configuration class method
		//public Configuration configure() throws HibernateException
		factory=new Configuration()
				 //   .configure() //loaded config from hibernate.cfg.xml
				    .buildSessionFactory();
		System.out.println("created SF .....");
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
