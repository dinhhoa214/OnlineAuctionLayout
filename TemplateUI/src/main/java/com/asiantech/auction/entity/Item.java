package com.asiantech.auction.entity;
 

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Item")
public class Item {
	public enum StatusBid{A,I}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int itemId;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Item Title must be between 1 and 100 characters long.")  
	private String itemTitle;
	
	@NotNull
	@Size(min = 1, max = 1000, message = "Item Description must be between 1 and 1000 characters long.")  
	private String itemDescription;
	
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BidStatus")
	private StatusBid statusBid;
	
	@NotNull 
	private String bidStartDate;
	@NotNull 
	private String bidEndDate;
	
	@NotNull 
	private long bidIncremenet;
	
	@NotNull 
	private long miniumBid;
	 
	private long currentBid;
	  
	private String itemImage; 
	
	@ManyToOne(optional=false) 
	private Category category;  
	public Item() { 
	}

	 

	public Item(int itemId, String itemTitle, String itemDescription,
			StatusBid statusBid, String bidStartDate, String bidEndDate,
			long bidIncremenet, long miniumBid, long currentBid,
			String itemImage, Category category) {
		super();
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.itemDescription = itemDescription;
		this.statusBid = statusBid;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.bidIncremenet = bidIncremenet;
		this.miniumBid = miniumBid;
		this.currentBid = currentBid;
		this.itemImage = itemImage;
		this.category = category;
	}



	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public StatusBid getStatusBid() {
		return statusBid;
	}

	public void setStatusBid(StatusBid statusBid) {
		this.statusBid = statusBid;
	}

	public String getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(String bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public String getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(String bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public long getBidIncremenet() {
		return bidIncremenet;
	}

	public void setBidIncremenet(long bidIncremenet) {
		this.bidIncremenet = bidIncremenet;
	}

	public long getMiniumBid() {
		return miniumBid;
	}

	public void setMiniumBid(long miniumBid) {
		this.miniumBid = miniumBid;
	}

	public long getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(long currentBid) {
		this.currentBid = currentBid;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	} 
	
} 
