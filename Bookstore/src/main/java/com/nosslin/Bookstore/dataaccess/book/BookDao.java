package com.nosslin.Bookstore.dataaccess.book;

import java.util.List;

import com.nosslin.Bookstore.entities.Book;

public interface BookDao {
	List<Book> findAll();
	Book findById(int id);
	List<Book> findByTitle(String title);
	Book saveBook(Book book);
	void updateBook(Book book);
	void deleteBook(Book book);
}
