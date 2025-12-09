package com.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);
	User findByEmail(String email);
	boolean existsByUserName(String userName);
	boolean existsByEmail(String email);

}
