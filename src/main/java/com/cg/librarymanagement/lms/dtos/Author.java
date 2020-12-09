package com.cg.librarymanagement.lms.dtos;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author 
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int authorid;
	

	@Column(name="first_name")
	private String firstName;
	

	
	@Column(name="last_name")
	private String lastName;
	

	
	@Column(name="email")
	private String email;


	@Column(name = "contactno")
	private String contactno;
	
	
	
	public Author() 
	{
		
	}

	public Author( String firstName, String lastName, String email, String contactno)
	{
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
		
	}

	
	

	public Author(int authorid, String firstName, String lastName, String email, String contactno) {
		super();
		this.authorid = authorid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=");
		builder.append(authorid);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", books=");
		
		return builder.toString();
	}
	
	
	
	
	
	
	

}
