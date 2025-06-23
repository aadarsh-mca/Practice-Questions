package com.cdac.dao.products;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Product;
import com.cdac.utils.HibernateUtils;

public class ProductDaoImpl implements ProductDao {
	
	@Override
	public Product addProduct(Product newProduct) {  // State - Transient (Heap)
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.persist(newProduct);  // State - Persistent (L1 cache)
			
			tx.commit();  // State - Persistent (L1 cache, DB)
			
			return newProduct;  // State - Detached (only DB)
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();  // directly cleared()
			
			throw e;
		}
	}

	@Override
	public Product getProduct(Long id) {
		Product fetchedProduct = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			// State - Persistent (L1 cache, DB)
			fetchedProduct = session.get(Product.class, id);
			
//			String jpql = "Select p From Product p Where p.id=:productId";
//			fetchedProduct = session.createQuery(jpql, Product.class)
//					.setParameter("productId", id)
//					.getSingleResult();
			
			tx.commit();  // State - Detached (only DB)
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			throw e;
		}
		return fetchedProduct;
	}

	@Override
	public List<Product> getAllProduct(LocalDate dateAfter) {
		List<Product> listOfProduct = null;
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String jpql = "Select new com.cdac.entities.Product(p.id, p.name, p.price) From Product p Where p.mfgDate<:dateAfter";
			
			listOfProduct = session.createQuery(jpql, Product.class)
					.setParameter("dateAfter", dateAfter)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			throw e;
		}
		
		return listOfProduct;
	}

	@Override
	public String updateProductPrice(String name, double newPrice) {
		String message = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			/**
			 * Using JPQL
			 * 
			 * createQuery(updateQuery)  // deprecated
			 */
//			String jpql = "Update Product p Set p.price=:newPrice Where p.name=:name";
//			
//			int updateCount = session.createQuery(jpql)
//				.setParameter("name", name)
//				.setParameter("newPrice", newPrice)
//				.executeUpdate();
//			
//			if(updateCount != 0) {
//				message = "====== [ " + updateCount + " Products updated successfully.... ] ======";
//			} else {
//				message = "====== [ Products updation failed !!! ] ======";
//			}
			
			
			/**
			 * 
			 * Using HQL
			 * 
			 */
//			String jpql = "Select p From Product p Where p.name=:name";
//			Product product = session.createQuery(jpql, Product.class)
//					.setParameter("name", name)
//					.getSingleResult();
//			if(product != null) {
//				product.setPrice(newPrice);
//				
//				message = "====== [ Product " + name + " updated successfully.... ] ======";
//			} else {
//				message = "====== [ Products updation failed !!! ] ======";
//			}
			
			
			/**
			 * 
			 * Mutation Query
			 * 
			 */
			String jpql = "Update Product p Set p.price=:newPrice Where p.name=:name";
			int updateCount = session.createMutationQuery(jpql)
					.setParameter("name", name)
					.setParameter("newPrice", newPrice)
					.executeUpdate();
			
			if(updateCount != 0) {
				message = "====== [ " + updateCount + " Products updated successfully.... ] ======";
			} else {
				message = "====== [ Products updation failed !!! ] ======";
			}
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			throw e;
		}
		return message;
	}

	@Override
	public List<Product> applyDiscount(int quantity, double discount) {
		List<Product> productsWithDiscount = null;
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			/**
			 * Using JPQL
			 * 
			 * mutationQuery(updateQuery)
			 */
			String jpql = "Update Product p Set p.price = (p.price - (p.price * :discount)) Where p.availableQuantity>:quantity";
			
			int updateCount = session.createMutationQuery(jpql)
					.setParameter("discount", (discount / 100))
					.setParameter("quantity", quantity)
					.executeUpdate();
			
			/**
			 * Using HQL
			 * 
			 * createQuery(updateQuery)  // deprecated
			 */
//			String jpql = "Select p from Product p Where p.availableQuantity>:quantity";
//			productsWithDiscount = session.createQuery(jpql, Product.class)
//					.setParameter("quantity", quantity)
//					.getResultList();
//			
//			int updateCount = 0;
//			for(Product prod : productsWithDiscount) {
//				prod.setPrice(prod.getPrice() * ((100-discount) / 100));
//				updateCount++;
//			}
//			
//			if(updateCount != 0) {
//				System.out.println("====== [ " + updateCount + " Products updated successfully.... ] ======");
//			} else {
//				System.out.println("====== [ Products updation failed !!! ] ======");
//			}
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) tx.rollback();
			
			throw e;
		}
		
		return productsWithDiscount;
	}

	@Override
	public String deleteProduct(Long id) {
		String message = null;
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

//			Product deletedProduct = session.get(Product.class, id);
//			deletedProduct = null;
//			if(deletedProduct == null) {
//				message = "====== [ Product deleted successfully.... ] ======";
//			} else {
//				message = "====== [ Product deletion failed !!! ] ======";
//			}
			
			String jpql = "Delete From Product Where id=:id";
			int deleteCount = session.createMutationQuery(jpql)
				.setParameter("id", id)
				.executeUpdate();
			
			if(deleteCount != 0) {
				message = "====== [ Product deleted successfully.... ] ======";
			} else {
				message = "====== [ Product deletion failed !!! ] ======";
			}
			
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null) tx.rollback();
		
			throw e;
		}
		
		return message;
	}

}
