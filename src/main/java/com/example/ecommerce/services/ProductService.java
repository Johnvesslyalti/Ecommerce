package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
