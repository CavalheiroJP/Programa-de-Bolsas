package com.project.products.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.products.controller.dto.ProductDetailsDto;
import com.project.products.controller.dto.ProductDto;
import com.project.products.controller.form.ProductForm;
import com.project.products.controller.form.UptadeProductForm;
import com.project.products.modelo.Product;
import com.project.products.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
 	public Page<ProductDto> list(@RequestParam(required = false)String nameProduct,@PageableDefault(sort = "id", direction = Direction.ASC)  Pageable paginacao) {

			if (nameProduct == null) {
			Page<Product> products = productRepository.findAll(paginacao);
			return ProductDto.converter(products);
		} else {
			Page<Product> product = productRepository.findByName(nameProduct, paginacao);
			return ProductDto.converter(product);
		}
	}
	
/*
	@GetMapping("/search")
	public Page<ProductDto> filtro(String nameProduct, Pageable paginacao) {
		if(nameProduct != null) {
			Page<Product> products = productRepository.findAll(paginacao);
			return ProductDto.converter(products);
		} else {
			List<Product> products = productRepository.findByPrice(nameProduct, nameProduct);
			return ProductDto.converter(products);
			
			
		}
	}
*/
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		Product product = form.converter(productRepository);
		productRepository.save(product);

		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}

	@GetMapping("/{id}")
	public Object findById(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(new ProductDetailsDto(product.get()));
		} 

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody @Valid UptadeProductForm form) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product topico = form.atualizar(id, productRepository);
			return ResponseEntity.ok(new ProductDto(topico));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
