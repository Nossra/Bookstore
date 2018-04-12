package com.nosslin.Bookstore.services.user;

import org.hibernate.Session;

import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.entities.User;
import com.nosslin.Bookstore.utilities.HibernateUtil;

public class UserService {
	public boolean login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String HQL_LOGIN = "FROM User WHERE username=:username AND password=:password";
		
		@SuppressWarnings("unchecked")
		User result = (User) session.createQuery(HQL_LOGIN)
			.setParameter("username", username)
			.setParameter("password", password)
			.setMaxResults(1)
			.getSingleResult();		
		
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}
}
