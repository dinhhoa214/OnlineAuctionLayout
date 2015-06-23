package com.asiantech.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.asiantech.auction.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
