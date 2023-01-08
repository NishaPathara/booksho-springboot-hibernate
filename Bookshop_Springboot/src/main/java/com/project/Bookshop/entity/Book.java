package com.project.Bookshop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Book {

	@Id
	private String book_id;
	private String title;
	private String author;
	private String publication;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	
	public Book() {

	}


	public Book(String book_id, String title, String author, String publication,
			com.project.Bookshop.entity.User user) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.user = user;
	}

	public Book(String book_id, String title, String author, String publication) {
		// TODO Auto-generated constructor stub
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publication = publication;
	}


	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setBook_name(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
