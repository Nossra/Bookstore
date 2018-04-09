package com.nosslin.Bookstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,
			length = 50)
	private String fullName;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "author", fetch = FetchType.LAZY)
	@Column(nullable = false)
	private List<Book> books;
	
	public Author() {} 
	
	public Author(String fullName) {
		super();
		this.setFullName(fullName);
		books = new ArrayList<>();
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		if (fullName.length() < 50) {
			this.fullName = fullName;
		} else {
			System.out.println("Name is too long.");
		}
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
