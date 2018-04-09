package com.nosslin.Bookstore.services.book;

import java.util.List;

import com.nosslin.Bookstore.dataaccess.book.BookDao;
import com.nosslin.Bookstore.dataaccess.book.BookDaoHibernateImpl;
import com.nosslin.Bookstore.entities.Book;

public class BookService implements BookServiceManager {
	public BookDao dao;
	
	public void setBookDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public void updateBook(Book book) {
		try {
			dao.updateBook(book);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void deleteBook(Book book) {
		try {
			dao.deleteBook(book);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public Book saveBook(Book book) {
		try {
			return dao.saveBook(book);
		} catch (Exception e) {
			e.getMessage();
		} 
		return null;
	}

	@Override
	public List<Book> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Book> findByTitle(String title) {
		try {
			return dao.findByTitle(title);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public Book findById(int id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}	
}
