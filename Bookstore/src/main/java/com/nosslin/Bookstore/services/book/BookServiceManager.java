package com.nosslin.Bookstore.services.book;

import java.util.List;

import com.nosslin.Bookstore.entities.Book;

public interface BookServiceManager {
	void updateBook(Book book);
	void deleteBook(Book book);
	Book saveBook(Book book);
	List<Book> findAll();
	List<Book> findByTitle(String title);
	Book findById(int id);
}
