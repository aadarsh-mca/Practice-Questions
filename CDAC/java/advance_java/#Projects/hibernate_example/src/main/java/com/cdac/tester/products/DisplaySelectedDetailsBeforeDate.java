package com.cdac.tester.products;

/*
 *  Display   id , name , price  of all the products 
 *  manufactured before specified date

 */
import com.cdac.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.user.UserDao;
import com.cdac.dao.user.UserDaoImpl;
import com.cdac.dao.products.ProductDao;
import com.cdac.dao.products.ProductDaoImpl;
import com.cdac.entities.UserRole;

public class DisplaySelectedDetailsBeforeDate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = HibernateUtils.getSessionFactory()
			) {
			
			// create DAO instance
			ProductDao dao = new ProductDaoImpl();
			
			System.out.println("Enter manufacture date");
			
			// invoke dao's method
			dao.getAllProduct(LocalDate.parse(sc.next()))
					.forEach(p -> 
					System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice()));
			
			
		} // sf => DBCP - closing
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}