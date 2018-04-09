package com.nosslin.Bookstore.services.author;

import java.util.List;

import com.nosslin.Bookstore.entities.Author;

public interface AuthorServiceManager {
	List<Author> findAll();
	Author findById(int id);
	List<Author> findByName(String name);
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Author author);
}
