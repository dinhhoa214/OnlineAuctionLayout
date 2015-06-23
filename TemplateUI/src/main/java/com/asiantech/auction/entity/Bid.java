package com.asiantech.auction.entity; 
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity
@Table(name="Bid")
public class Bid {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int numberIndex;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Bid ID valirdation ")  
	private String bidId;
	
	@NotNull 
	private long amount;
	 
	private String createrId;
	 
	private int itemId;
	 
	private String bidderId;

	public Bid() { 
	}

	public Bid(int numberIndex, String bidId, long amount, String createrId,
			int itemId, String bidderId) {
		super();
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

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBidderId() {
		return bidderId;
	}

	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}
	
	
}
