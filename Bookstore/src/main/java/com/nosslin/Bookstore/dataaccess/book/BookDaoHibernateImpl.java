package com.nosslin.Bookstore.dataaccess.book;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.hibernate.Session;
import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.entities.Book;
import com.nosslin.Bookstore.services.author.AuthorService;
import com.nosslin.Bookstore.utilities.HibernateUtil;

public class BookDaoHibernateImpl implements BookDao {

	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Book> findAll() {
		String HQL_BY_TITLE = "FROM Book ";
		
		@SuppressWarnings("unchecked")
		List<Book> result = (List<Book>) session.createQuery(HQL_BY_TITLE)
			.getResultList();		
		
		return result;
	}

	@Override
	public Book findById(int id) {
		String HQL_BY_ID = "FROM Book WHERE id=:id";
		
		@SuppressWarnings("unchecked")
		Book result = (Book) session.createQuery(HQL_BY_ID)
			.setParameter("id", id)
			.getSingleResult();		
		
		return  result;
	}

	@Override
	public List<Book> findByTitle(String title) {
		String HQL_BY_TITLE = "FROM Book WHERE title=:title";
		
		@SuppressWarnings("unchecked")
		List<Book> result = (List<Book>) session.createQuery(HQL_BY_TITLE)
			.setParameter("title", title)
			.getResultList();		
		
		return result;
	}

	@Override
	public Book saveBook(Book book) {
		try {
			session.beginTransaction();
			Book b = (Book) session.merge(book);
			session.getTransaction().commit();
			return b;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateBook(Book book)  {
		session.beginTransaction();
		session.merge(book);
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteBook(Book book) {
		session.beginTransaction();
		session.remove(book);
		session.getTransaction().commit();
	}

}
