package com.asiantech.auction.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  
import org.springframework.stereotype.Service;

import com.asiantech.auction.entity.Bid;
import com.asiantech.auction.repository.BidRepository;
 
@Service(BidService.NAME)
public class BidServiceImpl implements BidService{
	@Resource
	BidRepository bidRepository;
	@Override
	public Bid saveOrUpdate(Bid bid) {
		return bidRepository.save(bid);
	}

	@Override
	public Bid getById(int id) { 
		return bidRepository.findOne(id);
	}

	@Override
	public void deleteById(int id) {
		bidRepository.delete(id); 
		
	}

	@Override
	public List<Bid> getAll() {
		return bidRepository.findAll();
	}

	@Override
	public Page<Bid> getAllBidAndPagination(Pageable pageable) {
		return bidRepository.findAll(pageable);
	}
	
}
