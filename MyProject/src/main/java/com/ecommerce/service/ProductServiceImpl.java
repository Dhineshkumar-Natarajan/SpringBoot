package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;

	@Override
	public Optional<Product> getProductById(int id) throws ProductNotFoundException {

		List<Product> productList = productRepository.findAll();
		
		return Optional.ofNullable(productList.stream()
											   .filter(p->p.getId()==id)
											   .findFirst()
											   .orElseThrow(()-> {throw new ProductNotFoundException("Product with given "+id+" not found");}));
		

		

	}
	
	
	@Override
	public List<Product> getAllProducts() {

		List<Product> productList = productRepository.findAll();

		return productList;

	}

//		if (id == 10) {
//			Product p1 = new Product();
//			p1.setId((long) 10);
//			p1.setName("Laptop");
//			p1.setPrice((double) 30000);
//
//			return p1;
//		} else {
//
//			throw new ProductNotFoundException("Product with given id:" + id + " not found");
//		}
//	}

	@Override
	public void addProduct(Product product) {

		productRepository.save(product);
	}
}
