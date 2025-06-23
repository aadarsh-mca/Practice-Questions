package com.cdac.dao.products;

import java.time.LocalDate;
import java.util.List;

import com.cdac.entities.Product;

public interface ProductDao {
	
	Product addProduct(Product newProduct);

	Product getProduct(Long id);
	
	List<Product> getAllProduct(LocalDate dateAfter);
	
	String updateProductPrice(String name, double newPrice);
	
	List<Product> applyDiscount(int quantity, double discount);
	
	String deleteProduct(Long id);
}
