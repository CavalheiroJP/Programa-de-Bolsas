package com.project.products.service;

import java.util.Collection;

import com.project.products.modelo.Product;

public interface ProductService {
	
	Collection<Product> findAll();
	
	Product findOne (Long id);
	
	Product create(Product product);
	
	Product update(Product product);
	
	void delete(Long id);
	
	
	

}
