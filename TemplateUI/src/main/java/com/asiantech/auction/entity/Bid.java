package com.asiantech.auction.entity; 
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity 
public class Bid {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int numberIndex;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Bid ID valirdation ")  
	private String bidId;
	
	@NotNull 
	private long amount;
	@ManyToOne 
	private User createrId;
	 
	@ManyToOne
	private Item itemId;
	@ManyToOne 
	private User bidderId;

	public Bid() { 
	}
	 
	public Bid(int numberIndex, String bidId, long amount, User createrId,
			Item itemId, User bidderId) { 
		this.numberIndex = numberIndex;
		this.bidId = bidId;
		this.amount = amount;
		this.createrId = createrId;
		this.itemId = itemId;
		this.bidderId = bidderId;
	}

	public int getNumberIndex() {
		return numberIndex;
	}

	public void setNumberIndex(int numberIndex) {
		this.numberIndex = numberIndex;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	} 
	public Item getItemId() {
		return itemId;
	}
	
	public User getCreaterId() {
		return createrId;
	}

	public void setCreaterId(User createrId) {
		this.createrId = createrId;
	}

	public User getBidderId() {
		return bidderId;
	}

	public void setBidderId(User bidderId) {
		this.bidderId = bidderId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	} 
}
