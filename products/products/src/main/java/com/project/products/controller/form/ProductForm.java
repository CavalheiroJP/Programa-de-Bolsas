package com.project.products.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.project.products.modelo.Product;
import com.project.products.repository.ProductRepository;

public class ProductForm {                                                // As beans são colocadas nos Forms para exigir parâmetros do usuário.
	
	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String description;
	
	@NotNull
	private Double price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product update(Long id, ProductRepository productRepository) {
		Product product = productRepository.getOne(id);
		product.setName(this.name);
		product.setDescription(this.description);
		
		return product;
	}
	public Product converter(ProductRepository repository) {
		return new Product(name, description, price);
	}
	
	

}
