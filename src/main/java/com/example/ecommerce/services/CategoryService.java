package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
