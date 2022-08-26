package com.project.products.controller.dto;

import java.time.LocalDateTime;
import com.project.products.modelo.Product;



public class ProductDetailsDto {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private LocalDateTime dataCriacao;

	
	public ProductDetailsDto (Product product){
			this.id = product.getId();
			this.name = product.getName();
			this.description = product.getDescription();
			this.price = product.getPrice();
			this.dataCriacao = product.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public Double getPrice() {
		return price;
	}
	
	
}
