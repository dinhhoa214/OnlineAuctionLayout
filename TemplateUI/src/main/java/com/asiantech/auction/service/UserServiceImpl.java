package com.asiantech.auction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asiantech.auction.entity.User;
import com.asiantech.auction.repository.UserRepository;

@Service(UserService.NAME)
public class UserServiceImpl implements UserService{
	@Resource
	UserRepository userRepositoty;

	@Override
	public User saveOrUpdate(User user) { 
		// kiem tra userName co trung ko?
		/*String newUserName = user.getUserName();
		String oldUserName = userRepositoty.findOneByName(user.getUserName()).getUserName();
		if(newUserName.equalsIgnoreCase(oldUserName))
			return user;*/
		return userRepositoty.save(user); 
	}

	@Override
	public User getById(int id) {
		return userRepositoty.findOne(id);
	}

	@Override
	public void deleteById(int id) {
		userRepositoty.delete(id);
	}

	@Override
	public List<User> getAll() { 
		return userRepositoty.findAll();
	}

	@Override
	public Page<User> getAllUserAndPagination(Pageable pageable) {
		return userRepositoty.findAll(pageable);
	}
	
}
