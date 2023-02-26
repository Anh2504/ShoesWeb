package com.cdweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "content", length = 5000)
	private String content;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private Set<OrderProduct> listOrder = new HashSet<OrderProduct>();
	
	public Product() {
		
	}

	

	public Product(Long id, String name, long price, String content, String sex, String image, Category category,
			Set<com.cdweb.model.OrderProduct> listOrder) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.content = content;
		this.sex = sex;
		this.image = image;
		this.category = category;
		this.listOrder = listOrder;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public Set<OrderProduct> getListOrder() {
		return listOrder;
	}



	public void setListOrder(Set<OrderProduct> listOrder) {
		this.listOrder = listOrder;
	}

	
	
	
	
	
	
}
