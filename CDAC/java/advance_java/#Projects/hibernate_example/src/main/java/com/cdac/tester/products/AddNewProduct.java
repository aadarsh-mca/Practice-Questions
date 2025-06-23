package com.cdac.tester.products;

import com.cdac.utils.HibernateUtils;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.products.ProductDao;
import com.cdac.dao.products.ProductDaoImpl;
import com.cdac.entities.Category;
import com.cdac.entities.Product;

public class AddNewProduct {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = HibernateUtils.getSessionFactory()
			) {
			
			// create Product DAO instance
			ProductDao productDao=new ProductDaoImpl();
			
			System.out.println("Enter product details - name, Category productCategory, \r\n"
					+ "			String description, LocalDate manufactureDate, double price,\r\n"
					+ "			int availableQuantity");
			
			Product product = new Product(sc.next(), 
					Category.valueOf(sc.next().toUpperCase()), sc.next(), 
					LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			
			//invoke dao's method
			System.out.println(productDao.addProduct(product));
	
			} //sf => DBCP - closing
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}