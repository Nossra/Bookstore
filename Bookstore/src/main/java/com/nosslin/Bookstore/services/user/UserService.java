package com.nosslin.Bookstore.services.user;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.entities.User;
import com.nosslin.Bookstore.utilities.HibernateUtil;

public class UserService {
	public boolean login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String HQL_LOGIN = "FROM User WHERE username=:username AND password=:password";
		
		try {
			session.createQuery(HQL_LOGIN)
				.setParameter("username", username)
				.setParameter("password", password)
				.setMaxResults(1)
				.getSingleResult();	
			
			return true;
		} catch(NoResultException ex) {
			return false;
		}
	}
}
