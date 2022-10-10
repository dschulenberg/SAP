package com.skilldistillery.sap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sap.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserById(int userId);
	User findByUsername(String username);

}
