package com.project.products.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.project.products.modelo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { //<Entidade, Atributo (Primary Key)>

	Page<Product> findByName(String nameProduct, Pageable paginacao);
	
/*
	@Query (nativeQuery = true,	value = "SELECT * FROM Product WHERE (price <= :max_price AND price >= :min_price) "
			+ "OR (price <= :max_price OR price >= :min_price)")
	Page<Product> findByPrice(@Param ("max_price") String max_price, @Param ("min_price") String min_price);
	
*/

}
