package com.nosslin.Bookstore.dataaccess.author;

import java.util.List;

import org.hibernate.Session;

import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.utilities.HibernateUtil;

public class AuthorDaoHibernateImpl implements AuthorDao {

	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	public List<Author> findAll() {
		String HQL_BY_ID = "FROM Author ";
		
		@SuppressWarnings("unchecked")
		List<Author> result = (List<Author>) session.createQuery(HQL_BY_ID)
			.getResultList();
		return  result;
	}

	@Override
	public Author findById(int id) {
		String HQL_BY_ID = "FROM Author WHERE id=:id";
		
		@SuppressWarnings("unchecked")
		Author result = (Author) session.createQuery(HQL_BY_ID)
			.setParameter("id", id)
			.setMaxResults(1)
			.getSingleResult();		
		return  result;
	}

	@Override
	public List<Author> findByName(String name) {
		String HQL_BY_NAME = "FROM Author WHERE fullName=:fullName";
		
		@SuppressWarnings("unchecked")
		List<Author> result = (List<Author>) session.createQuery(HQL_BY_NAME)
			.setParameter("fullName", name)
			.getResultList();		
		return result;
	}

	@Override
	public void saveAuthor(Author author) {
		try {
			session.beginTransaction();
			session.persist(author);
			session.getTransaction().commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	@Override
	public void updateAuthor(Author author) {
		session.beginTransaction();
		session.merge(author);
		session.getTransaction().commit();
	}

	@Override
	public void deleteAuthor(Author author) {
		session.beginTransaction();
		session.remove(author);
		session.getTransaction().commit();
	}
}
