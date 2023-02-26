package com.cdweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "post_comments", 
			joinColumns = {@JoinColumn(name = "post_id") },
			inverseJoinColumns = {@JoinColumn(name = "comments_id") })
			Set<Comment> comments = new HashSet<>();

	public Post() {

	}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		comments = comments;
	}

}
