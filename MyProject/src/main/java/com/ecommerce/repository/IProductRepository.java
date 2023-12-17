package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
