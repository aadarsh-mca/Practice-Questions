package com.cdac.dao.user;

import org.hibernate.*;
import com.cdac.entities.User;
import com.cdac.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {
	
	@Override
	public String signUp(User newUser) {
		String message = "User Sign-Up failed !!!";
		
		/** 1. Get Hibernate Session
		 * 
		 * getCurrentSession returns a pooled out connection from DB Connection pool
		 * 
		 */
		Session session = HibernateUtils.getSessionFactory().getCurrentSession(); 
		
		// 2. Begin a transaction
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			/**
			 * Inserting a new record
			 * 
			 * public void persist(Object transientEntity) throws HibernateException
			 * 
			 * transienyEntity --> not yet persistent entity
			 */
			session.persist(newUser);
			
			tx.commit();
			
			message = "User signed up successfully !!!" + newUser.getUserId();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			/**
			 * re-throwing the same error
			 * to identify caller about some HibernateException (Runtime Exception)
			 */
			throw e;
		} 
//		finally {
//			session.close();
//		}
		
		return message;
	}

}
