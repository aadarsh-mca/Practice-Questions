package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

public class FoodItemDaoImpl implements FoodItemDao {

	@Override
	public String addFoodItemToResturant(Long restaurantId, FoodItem foodItem) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get restaurant details from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			if (restaurant != null) {
				// => valid restaurant
//				//establish bi dir association
//				restaurant.getFoodItems().add(foodItem);//parent -> child
//				foodItem.setMyRestaurant(restaurant);//child -> parent
				restaurant.addFoodItem(foodItem);
				// session.persist(foodItem); - works auto with cascade option
				mesg = "added ";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String addFoodItemsToResturant(Long restaurantId, List<FoodItem> foodItems) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get restaurant details from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			if (restaurant != null) {
				for (FoodItem foodItem : foodItems) {
					// => valid restaurant
					restaurant.getFoodItems().add(foodItem);
					foodItem.setMyRestaurant(restaurant);
					session.persist(foodItem);
				}
				mesg = "added ";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String removeFoodItem(Long restaurantId, Long foodItemId) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get restaurant details from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			// 4. get fodd item details from its id
			FoodItem foodItem = session.get(FoodItem.class, foodItemId);
			// validate
			if (restaurant != null && foodItem != null && restaurant.getFoodItems().contains(foodItem)) {
				System.out.println("Restaurant -- " + restaurant.getFoodItems().get(0));
				System.out.println("Food Item -- " + foodItem);
				restaurant.removeFoodItem(foodItem);
				mesg = "success!";
			}
			tx.commit();//DML delete - food_item
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

}
