package com.asiantech.auction.entity;  
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.EnumType;
import javax.persistence.Enumerated; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.validation.constraints.NotNull; 
 

@Entity 
public class User {
	public enum Role{ROLE_ADMIN,ROLE_USER,ROLE_VISITER}
	
	@Id   
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	  
	@Column(unique=true)
	@NotNull()
	private String userName;
	
	@NotNull 
	private String password;
	
	@Enumerated(EnumType.STRING) 
	private Role Role;
	
	@NotNull 
	private String iformation; 
	private float rating; 
	private float totalRating; 
	private String image;
	private boolean block;

	public User() { 
	}   
	
	public User(int userId, String userName, String password,
			com.asiantech.auction.entity.User.Role role, String iformation,
			float rating, float totalRating, String image, boolean block) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		Role = role;
		this.iformation = iformation;
		this.rating = rating;
		this.totalRating = totalRating;
		this.image = image;
		this.block = block;
	}

	public int getUserId() {
		return userId;
	}
	 

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	public String getIformation() {
		return iformation;
	}

	public void setIformation(String iformation) {
		this.iformation = iformation;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(float totalRating) {
		this.totalRating = totalRating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}
	
	
}
