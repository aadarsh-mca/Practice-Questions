package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

	@Override
	public String addResturant(Restaurant newRestaurant) {
		String mesg = "adding restaurant failed !!!!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(newRestaurant);
			tx.commit();
			mesg = "added new restaurant , ID" + newRestaurant.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public Restaurant getRestaurantDetails(String restaurantName) {
		Restaurant restaurant = null;
		String jpql = "select r from Restaurant r where r.name=:nm";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			restaurant = session.createQuery(jpql, Restaurant.class).setParameter("nm", restaurantName)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;// in case success - DETACHED or in case of failure - throws NOResultExc
	}

	@Override
	public Restaurant getRestaurantWithMenuDetails(String restaurantName) {
		Restaurant restaurant = null;
//		String jpql = "select r from Restaurant r where r.name=:nm";
		String jpql = "select r from Restaurant r left join fetch r.foodItems where r.name=:nm";
		
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			restaurant = session.createQuery(jpql, Restaurant.class)
					.setParameter("nm", restaurantName)
					.getSingleResult();//select - restaurants
			//simply suggest or hint to hibernate .
//			restaurant.getFoodItems().size(); //select - food_items
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;
	}

	@Override
	public Restaurant getOrLoadRestaurantDetails(Long restaurantId) {
		Restaurant restaurant = null;
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return restaurant;
	}

	@Override
	public String deleteRestaurant(Long restaurantId) {
		String message = "Failed !!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			
			if(restaurant != null) {
				session.remove(restaurant);
			}
			
			tx.commit();
			
			message = "Successfully Delete the restaurant and its food items !!!";
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			throw e;
		}
		
		return message;
	}

}
