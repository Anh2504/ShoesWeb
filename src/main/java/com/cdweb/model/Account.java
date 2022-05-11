package com.cdweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "account12")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "email", unique = true)
	@NotEmpty(message="Email khÃ´ng Ä‘Æ°Æ¡Ì£c Ä‘ÃªÌ‰ trÃ´Ì�ng")
	@Email(message = "Sai Ä‘iÌ£nh daÌ£ng email")
	private String email;

	@Column(name = "name", columnDefinition="nvarchar")
	@NotEmpty(message="TÃªn khÃ´ng Ä‘Æ°Æ¡Ì£c Ä‘ÃªÌ‰ trÃ´Ì�ng")
	private String name;

	@Column(name = "account_password")
	@NotEmpty(message="MÃ¢Ì£t khÃ¢Ì‰u khÃ´ng Ä‘Æ°Æ¡Ì£c Ä‘ÃªÌ‰ trÃ´Ì�ng")
	private String password;

	@Column(name = "phone")
	//@NotEmpty(message="SÃ´Ì� Ä‘iÃªÌ£n thoaÌ£i khÃ´ng Ä‘Æ°Æ¡Ì£c Ä‘ÃªÌ‰ trÃ´Ì�ng")
	private long phone;

	@Column(name = "address", columnDefinition="nvarchar")
	@NotEmpty(message="Ä�iÌ£a chiÌ‰ khÃ´ng Ä‘Æ°Æ¡Ì£c Ä‘ÃªÌ‰ trÃ´Ì�ng")
	private String address;

	public Account() {
		
	}
	
	public Account(String email, String name, String password, long phone, String address) {

		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
