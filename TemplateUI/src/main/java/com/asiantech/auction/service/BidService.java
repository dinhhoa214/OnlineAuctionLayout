package com.asiantech.auction.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asiantech.auction.entity.Bid;

public interface BidService {
	public static String NAME = "bidService";
	// CRUD operations
	// Save or Update
	public Bid saveOrUpdate(Bid bid);

	// Read
	public Bid getById(int id);

	// Delete
	public void deleteById(int id);

	// Get All
	public List<Bid> getAll();

	// Get All and Paging
	Page<Bid> getAllBidAndPagination(Pageable pageable); 
}
