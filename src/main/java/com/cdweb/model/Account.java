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
@Table(name = "Account12")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email", unique = true)
	@NotEmpty(message="Email không được để trống")
	@Email(message = "Sai định dạng email")
	private String email;

	@Column(name = "name", columnDefinition="nvarchar")
	@NotEmpty(message="Tên không được để trống")
	private String name;

	@Column(name = "account_password")
	@NotEmpty(message="Mật khẩu không được để trống")
	private String password;

	@Column(name = "phone")
	//@NotEmpty(message="Số điện thoại không được để trống")
	private long phone;

	@Column(name = "address", columnDefinition="nvarchar")
	@NotEmpty(message="Địa chỉ không được để trống")
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
