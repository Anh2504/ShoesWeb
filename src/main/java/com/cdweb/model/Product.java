package com.cdweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producttest")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", columnDefinition="ntext")
	private String name;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "content", columnDefinition="ntext")
	private String content;
	
	@Column(name = "image")
	private String image;
	
	public Product() {
		
	}

	public Product(String name, long price, String content, String image) {
		super();
		this.name = name;
		this.price = price;
		this.content = content;
		this.image = image;
	}

	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
}
