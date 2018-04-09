package com.nosslin.Bookstore.dataaccess.book;

import java.util.List;

import com.nosslin.Bookstore.entities.Book;

public class BookDaoTestingImpl implements BookDao {

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		System.out.println("Book saved to console: " + book.getTitle());
		return book;
		
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("Book updated into console: " + book.getTitle());
		
	}

	@Override
	public void deleteBook(Book book) {
		System.out.println(book.getTitle() + " is now deleted.");
	}

}
