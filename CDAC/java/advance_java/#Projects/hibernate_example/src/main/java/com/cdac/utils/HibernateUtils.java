package com.cdac.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	/**
	 * Initializing session factory in static init block for singleton instance
	 */
	static {
		System.out.println("====== [ Hibernate Utils static init block called !!! ] ======");
		/**
		 * Creating an instance of configuration 
		 * 
		 * from configuration.xml
		 */
		Configuration config = new Configuration().configure();
		
		/**
		 * Creating a singleton instance of session factory
		 * 
		 * from singleton configuration instance
		 */
		sessionFactory = config.buildSessionFactory();
		System.out.println("====== [ SessionFactory instance created !!! ] ======");
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	} 
}
