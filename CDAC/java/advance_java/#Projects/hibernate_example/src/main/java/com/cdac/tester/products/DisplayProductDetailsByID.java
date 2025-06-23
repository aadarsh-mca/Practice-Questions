package com.cdac.tester.products;

import com.cdac.utils.HibernateUtils;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.products.ProductDao;
import com.cdac.dao.products.ProductDaoImpl;

public class DisplayProductDetailsByID {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = HibernateUtils.getSessionFactory()
			) {

			ProductDao dao = new ProductDaoImpl();
			
			System.out.println("Enter product id");
			
			//invoke dao's method
			System.out.println(dao.getProduct(sc.nextLong()));
			
		} //sf => DBCP - closing
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}