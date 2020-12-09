package com.cg.librarymanagement.lms.dtos;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	private String password;
	

	private String firstName;
	
	private String lastName;
	

	private String mobileNo;
	

	private String email;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Address_fk")
	private UserAddress address;
	
	public User() {
		
	}
	public User(Integer id,String password, String firstName, String lastName, String mobileno, String email, UserAddress address) {
		super();
		this.id=id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileno;
		this.email = email;
		this.address=address;
	}


	public User(String password, String firstName, String lastName, String mobileno, String email, UserAddress address) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileno;
		this.email = email;
		this.address=address;
	}

	public Integer getUserid() {
		return id;
	}
	
	public void setUserid(Integer id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMobileno() {
		return mobileNo;
	}
	
	public void setMobileno(String mobileno) {
		this.mobileNo = mobileno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User{");
		sb.append("id:").append(id).append(",");
		sb.append("Password:").append(password).append(",");
		sb.append("FirstName:").append(firstName).append(",");
		sb.append("LastName:").append(lastName).append(",");
		sb.append("MobileNo:").append(mobileNo).append(",");
		sb.append("Email:").append(email).append(",");
		sb.append("Address:").append(address).append("");
		sb.append("}");
		
		return sb.toString();
	}
	
	
}