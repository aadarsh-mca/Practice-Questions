//package com.cdac.dao;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.cdac.entities.Restaurant;
//
//import jakarta.persistence.EntityManager;
//
//@Repository
//public class RestaurantDaoImpl implements RestaurantDao {
//	//depcy
//	@Autowired //byType - Filed level D.I
////private SessionFactory factory;
//	private EntityManager manager;
//
//	@Override
//	public List<Restaurant> getAll() {
//		String jpql="select r from Restaurant r";
//		// TODO Auto-generated method stub
//		return manager
//				.createQuery(jpql, Restaurant.class)
//				.getResultList();
//	}
//
//}
