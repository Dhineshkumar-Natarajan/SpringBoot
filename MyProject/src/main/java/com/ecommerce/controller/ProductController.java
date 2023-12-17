package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	IProductService productService;

	@GetMapping(value = "/findById/{id}")
	public  Optional<Product> getProductById(@PathVariable int id) {

		return productService.getProductById(id);

	}
	
	
	@GetMapping(value = "/getAllProducts")
	public List<Product> getAllProducts() {
		
		return productService.getAllProducts();
		
	}
	
	@PostMapping(value = "/addProduct")
	public void addProduct(@RequestBody Product product) {

		 productService.addProduct(product);

	}
	

}
