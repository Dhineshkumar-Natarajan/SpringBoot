package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
