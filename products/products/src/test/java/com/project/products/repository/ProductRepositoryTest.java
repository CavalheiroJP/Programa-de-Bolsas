package com.project.products.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.products.modelo.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository repository;
	
	@Test	
	public void buscaProdutosPorNome() {
		String nameProduct = "Dragonflight: Base Edition";
		Product products = (Product) repository.findByName(nameProduct, null);
		Assert.assertNotNull(products);
		Assert.assertEquals(nameProduct, products.getName());
	}
	
	@Test	
	public void naoDeveriaCarregar() {
		String nameProduct = "Produto";
		Product products = (Product) repository.findByName(nameProduct, null);
		Assert.assertNull(products);
	}
}
