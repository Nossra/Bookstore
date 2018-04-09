package com.nosslin.Bookstore.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nosslin.Bookstore.Container.Container;
import com.nosslin.Bookstore.ViewModels.BookViewModel;
import com.nosslin.Bookstore.dataaccess.book.BookDaoHibernateImpl;
import com.nosslin.Bookstore.entities.Book;
import com.nosslin.Bookstore.services.book.BookService;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {
	private BookService dao;
	
	public BookController() {
		this.dao = Container.getBookService(new BookDaoHibernateImpl());
	}
	 
	@GET
	public Response get() {
		List<Book> books = dao.findAll();
		List<BookViewModel> avm = new ArrayList<BookViewModel>();
		
		for (int i = 0; i < books.size(); i++) {
			avm.add(new BookViewModel(
					books.get(i).getId(), 
					books.get(i).getTitle(), 
					books.get(i).getNrOfPages(),
					"dummyName"
				//	books.get(i).getAuthor().getFullName() 	//AuthorId
			));
		}
		return Response.ok(avm).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getBookById(@PathParam("id") int id) {
		System.out.println("GETBOOKBYID GOT CALLED");
		Book book = dao.findById(id);
		BookViewModel avm = new BookViewModel(
				book.getId(), 
				book.getTitle(), 
				book.getNrOfPages(), 
				"dummyName"); //book.getAuthor().getFullName());
		return Response.ok(avm).build();
	}

	@POST
	public Response create(Book entity) {
		System.out.println("BOOKCONTROLLER POST CALLED");
		dao.saveBook(entity);
		return Response.status(201).entity(entity).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@DefaultValue("0") @PathParam("id") int id, Book entity) {
		System.out.println("BOOKCONTROLLER PUT WAS CALLED");
		Book objectToBeChanged = dao.findById(id);
		objectToBeChanged.setTitle(entity.getTitle());
		objectToBeChanged.setNrOfPages(entity.getNrOfPages());
		dao.updateBook(objectToBeChanged);
		return Response.status(200).entity(entity).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@DefaultValue("0") @PathParam("id") int id) {
		System.out.println("BOOKCONTROLLER DELETE CALLED");
		Book objectToBeDeleted = dao.findById(id);
		dao.deleteBook(objectToBeDeleted);
		return Response.status(200).entity(objectToBeDeleted).build();
	}
}
