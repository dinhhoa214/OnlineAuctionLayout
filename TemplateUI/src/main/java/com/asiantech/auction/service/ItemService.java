package com.asiantech.auction.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;   

import com.asiantech.auction.entity.Item;
public interface ItemService {
	public static String NAME = "itemService";
	// CRUD operations
	// Save or Update
	public Item saveOrUpdate(Item item);

	// Read
	public Item getById(int id);

	// Delete
	public void deleteById(int id);

	// Get All
	public List<Item> getAll();

	// Get All and Paging
	Page<Item> getAllItemAndPagination(Pageable pageable); 
}
