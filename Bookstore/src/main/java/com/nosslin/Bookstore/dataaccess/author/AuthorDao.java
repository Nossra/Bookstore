package com.nosslin.Bookstore.dataaccess.author;

import java.util.List;

import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.entities.Book;

public interface AuthorDao {
	List<Author> findAll();
	Author findById(int id);
	List<Author> findByName(String name);
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Author author);
}
