package com.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.model.User;

public interface SignUpRepository extends JpaRepository <User, String> {
	

}
