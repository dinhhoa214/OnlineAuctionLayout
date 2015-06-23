package com.asiantech.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asiantech.auction.entity.Item;
 

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
