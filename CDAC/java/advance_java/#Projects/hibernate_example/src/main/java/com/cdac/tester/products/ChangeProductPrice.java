package com.cdac.tester.products;

/*
 * 4. Change Product price
   i/p - product name , price offset
   o/p - message
 */
import com.cdac.utils.HibernateUtils;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.products.ProductDao;
import com.cdac.dao.products.ProductDaoImpl;

public class ChangeProductPrice {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = HibernateUtils.getSessionFactory();
			) {
			
			ProductDao dao = new ProductDaoImpl();
			
			
			System.out.println("Enter product name n price offset");
			
			// invoke dao's method
			System.out.println(dao.updateProductPrice(sc.nextLine(), sc.nextDouble()));
			
		} // sf => DBCP - closing
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}