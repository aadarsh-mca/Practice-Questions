package com.cdac.tester.products;

/*
 *  5. Apply discount to all products , whose available quantity > specified quantity
	i/p - quantity n discount in %
 */
import com.cdac.utils.HibernateUtils;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.products.ProductDao;
import com.cdac.dao.products.ProductDaoImpl;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = HibernateUtils.getSessionFactory();
			) {
			
			ProductDao dao = new ProductDaoImpl();
			
			
			System.out.println("Enter product [ Quantity ] & [ discount - price offset ]");
			
			// invoke dao's method
			System.out.println(dao.applyDiscount(sc.nextInt(), sc.nextDouble()));
			
		} // sf => DBCP - closing
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}