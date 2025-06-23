package com.cdac.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.ProductDTO;
import com.cdac.entities.Product;
import com.cdac.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;	
	private final ModelMapper mapper;

	@Override
	public ApiResponse addProduct(ProductDTO dto) {
		Product product = mapper.map(dto, Product.class);
		productRepository.save(product);
		return new ApiResponse("Added new product with ID " + product.getId());
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public ApiResponse purchase(Long productId, int qty) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Invalid product id !!!!"));
		product.setQuantity(product.getQuantity() - qty);
		return new ApiResponse("Purchased product ");
	}//DML - update

	@Override
	public ApiResponse deleteProductDetails(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return new ApiResponse("deleted product");
		}
		return new ApiResponse("product deletion failed!");
	}

}
