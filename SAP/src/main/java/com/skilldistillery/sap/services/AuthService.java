package com.skilldistillery.sap.services;

import com.skilldistillery.sap.entities.User;

public interface AuthService {

	public User register(User user);

	public User getUserByUsername(String username);

	public User getUserById(int userId);

}
