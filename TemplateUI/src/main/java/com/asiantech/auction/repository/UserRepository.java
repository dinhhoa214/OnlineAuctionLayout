package com.asiantech.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import com.asiantech.auction.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.userName like %?1")
	User findOneByName(String username);
}
