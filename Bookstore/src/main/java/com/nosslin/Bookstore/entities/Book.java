package com.nosslin.Bookstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String title;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Author author;
	@Column(nullable = false)
	private int nrOfPages;
	
	public Book() {}
	
	public Book(String title, Author author, int pages) {
		this.setAuthor(author);
		this.setTitle(title);
		this.setNrOfPages(pages);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getNrOfPages() {
		return nrOfPages;
	}
	public void setNrOfPages(int nrOfPages) {
		this.nrOfPages = nrOfPages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
