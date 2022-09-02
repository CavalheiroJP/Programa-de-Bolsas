package com.project.products.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.project.products.modelo.Product;
import com.project.products.repository.ProductRepository;

public class UptadeProductForm {  //  Deve-se colocar aqui apenas o q deseja mudar
	
	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String description;
	

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

	public Product atualizar(Long id, ProductRepository productRepository) {
		Product product = productRepository.getOne(id);
		product.setName(this.name);
		product.setDescription(this.description);
		
		return product;
	}	
}
