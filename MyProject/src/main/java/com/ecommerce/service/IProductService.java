package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.model.Product;

public interface IProductService {

	public  Optional<Product> getProductById(int id);

	public void addProduct(Product product);

	public List<Product> getAllProducts();

}
