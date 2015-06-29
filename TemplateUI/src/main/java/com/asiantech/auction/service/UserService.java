package com.asiantech.auction.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 

import com.asiantech.auction.entity.User;

public interface UserService {
	public static String NAME = "userService";
	// CRUD operations
	// Save or Update
	public User saveOrUpdate(User user);

	// Read
	public User getById(int id);

	// Delete
	public void deleteById(int id);

	// Get All
	public List<User> getAll();

	// Get All and Paging
	Page<User> getAllUserAndPagination(Pageable pageable); 
}
