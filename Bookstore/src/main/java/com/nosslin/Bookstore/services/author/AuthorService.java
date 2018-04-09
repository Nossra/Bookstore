package com.nosslin.Bookstore.services.author;

import java.util.List;

import com.nosslin.Bookstore.dataaccess.author.AuthorDao;
import com.nosslin.Bookstore.entities.Author;

public class AuthorService implements AuthorServiceManager {

	private AuthorDao dao;
	
	public void setAuthorDao(AuthorDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Author> findAll() {
		return dao.findAll();
	}

	@Override
	public Author findById(int id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Author> findByName(String name) {
		try {
			return dao.findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		};
		return null;
	}

	@Override
	public void saveAuthor(Author author) {
		try {
			dao.saveAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	@Override
	public void updateAuthor(Author author) {
		try {
			dao.updateAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	@Override
	public void deleteAuthor(Author author) {
		try {
			dao.deleteAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
