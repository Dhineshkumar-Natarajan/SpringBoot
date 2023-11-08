package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.User;

public interface SignUpRepository extends JpaRepository <User, String> {
	

}
