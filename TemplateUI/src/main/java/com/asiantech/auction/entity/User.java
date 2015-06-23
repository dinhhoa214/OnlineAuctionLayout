package com.asiantech.auction.entity; 
import javax.persistence.Entity; 
import javax.persistence.EnumType;
import javax.persistence.Enumerated; 
import javax.persistence.Id; 
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity
@Table(name="User")
public class User {
	public enum Role{ROLE_ADMIN,ROLE_USER}
	
	@Id   
	private String userId;
	
	@NotNull
	@Size(min = 1, max = 100, message = "User name valirdation ")  
	private String name;
	
	@Enumerated(EnumType.STRING) 
	private Role Role;
	
	@NotNull
	@Size(min = 1, max = 1000, message = "Information user must be not empty!")  
	private String iformation;
	 
	private float rating;
	 
	private float totalRating;
	 
	private String image;

	public User() { 
	} 
	

	public User(String userId, String name,
			com.asiantech.auction.entity.User.Role role,
			String iformation, float rating, float totalRating, String image) {
		super();
		this.userId = userId;
		this.name = name;
		Role = role;
		this.iformation = iformation;
		this.rating = rating;
		this.totalRating = totalRating;
		this.image = image;
	}
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
