package com.project.Bookshop.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class User {

	@Id
	private String username;
	private String password;
	private String name;
	private String email;
	private String usertype;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Book> fav_books;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Book> read_ltr;

	public User() {

	}

	public User(String username, String password, String name, String email, String usertype, List<Book> fav_books,
			List<Book> read_ltr) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.usertype = usertype;
		this.fav_books = fav_books;
		this.read_ltr = read_ltr;
	}

	public User(String username, String password, String name, String email,String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.usertype=usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public List<Book> getFav_books() {
		return fav_books;
	}

	public void setFav_books(List<Book> fav_books) {
		this.fav_books = fav_books;
	}

	public List<Book> getRead_ltr() {
		return read_ltr;
	}

	public void setRead_ltr(List<Book> read_ltr) {
		this.read_ltr = read_ltr;
	}

}
