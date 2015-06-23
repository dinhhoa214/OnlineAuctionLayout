package com.asiantech.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.asiantech.auction.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Integer>{

}