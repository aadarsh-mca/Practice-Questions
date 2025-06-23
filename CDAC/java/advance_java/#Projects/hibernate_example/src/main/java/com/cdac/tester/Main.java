package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import java.time.LocalDate;

import com.cdac.dao.user.UserDao;
import com.cdac.dao.user.UserDaoImpl;
import com.cdac.entities.User;
import com.cdac.entities.UserRole;
import com.cdac.utils.HibernateUtils;

public class Main {
	
	public static void main(String[] args) {
		try(SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
				Scanner sc = new Scanner(System.in);
			) {
			
			
			
//			System.out.println("Enter user detail [firstName, lastName, email, password, dob, role]");
//			
//			UserDao userDao = new UserDaoImpl();
//			String msg = userDao.signUp(new User(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), UserRole.valueOf(sc.next().toUpperCase())));
//		
//			System.out.println(msg);
		}
		
		System.out.println("====== [ SessionFactoy destroyed !!! ] ======");
		System.out.println("====== [ Application terminated !!! ] ======");
	}
	
}
