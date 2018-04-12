package com.nosslin.Bookstore.app;

import org.hibernate.Session;

import com.nosslin.Bookstore.Container.Container;
import com.nosslin.Bookstore.dataaccess.author.AuthorDaoHibernateImpl;
import com.nosslin.Bookstore.dataaccess.book.BookDaoHibernateImpl;
import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.entities.Book;
import com.nosslin.Bookstore.entities.User;
import com.nosslin.Bookstore.services.author.AuthorService;
import com.nosslin.Bookstore.services.book.BookService;
import com.nosslin.Bookstore.services.user.UserService;

public class app {

	public static void main(String[] args) {
//		Author a = new Author("Ali");
//		Author a2 = new Author("Hasan");
//		Author a3 = new Author("Ahmad");
//		Book b = new Book("Da vinci koden", a, 320);
//		Book b2 = new Book("Inferno", a, 403);
//		
//		BookService bookService = Container.getBookService(new BookDaoHibernateImpl());
//		AuthorService authorService = Container.getAuthorService(new AuthorDaoHibernateImpl());
//		System.out.println(a.getFullName());
//		authorService.saveAuthor(a);
//		authorService.saveAuthor(a2);
//		authorService.saveAuthor(a3);
//		bookService.saveBook(b2);
//		bookService.saveBook(b);
//		Book newBook =  new Book("Java EE and Angular", authorService.findById(1), 3);
//		bookService.saveBook(newBook);
//		System.out.println(1);
//		Author author = authorService.findById(1);
//		System.out.println("what");
//		System.out.println(author.getFullName());
		UserService userService = new UserService();
		User u = new User();
		u.setPassword("1234");
		u.setUsername("Martin");
		
		System.out.println(userService.login("Martin", "1234"));
	}
}
