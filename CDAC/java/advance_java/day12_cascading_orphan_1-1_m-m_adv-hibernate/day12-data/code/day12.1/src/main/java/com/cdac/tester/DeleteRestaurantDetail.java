package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.RestaurantDao;
import com.cdac.dao.RestaurantDaoImpl;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;
import static com.cdac.utils.HibernateUtils.getFactory;

public class DeleteRestaurantDetail {
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			
			// create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant id ");
			
			long restaurantId = sc.nextLong();
			
			System.out.println(dao.deleteRestaurant(restaurantId));
		}
	}

}
