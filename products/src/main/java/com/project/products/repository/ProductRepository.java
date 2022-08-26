package com.project.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.products.modelo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { //<Entidade, Atributo (Primary Key)>

	List<Product> findByName(String nameProduct);
	


}
