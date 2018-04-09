package com.nosslin.Bookstore.Container;



import com.nosslin.Bookstore.dataaccess.author.AuthorDao;
import com.nosslin.Bookstore.dataaccess.book.BookDao;
import com.nosslin.Bookstore.services.author.AuthorService;
import com.nosslin.Bookstore.services.book.BookService;

public class Container {
 
	private Container() {}
	
	public static AuthorService getAuthorService(AuthorDao dao) {
		AuthorService service = new AuthorService();
//		AuthorDao dao = new AuthorDaoHibernateImpl();
		service.setAuthorDao(dao);
		
		return service;
	}
	
	public static BookService getBookService(BookDao dao) {
		BookService service = new BookService();
//		BookDao dao = new BookDaoHibernateImpl();
		service.setBookDao(dao);
		
		return service;
	}
}
