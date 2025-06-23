package com.cdac.service;

import java.util.List;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.ProductDTO;
import com.cdac.entities.Product;

public interface ProductService {
	ApiResponse addProduct(ProductDTO product);

	List<Product> getAllProducts();

	ApiResponse purchase(Long productId, int qty);

	ApiResponse deleteProductDetails(Long id);

}
