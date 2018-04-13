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
import com.nosslin.Bookstore.ViewModels.AuthorViewModel;
import com.nosslin.Bookstore.dataaccess.author.AuthorDaoHibernateImpl;
import com.nosslin.Bookstore.entities.Author;
import com.nosslin.Bookstore.filters.JWTRequired;
import com.nosslin.Bookstore.services.author.AuthorService;


@Path("authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@JWTRequired
public class AuthorController  {
	
	
	private AuthorService dao;
	
	public AuthorController() {
		this.dao = Container.getAuthorService(new AuthorDaoHibernateImpl());
	}
	 
	@GET
	public Response get() {
		List<Author> author = dao.findAll();
		List<AuthorViewModel> avm = new ArrayList<AuthorViewModel>();
		
		for (int i = 0; i < author.size(); i++) {
			avm.add(new AuthorViewModel(author.get(i).getId(), author.get(i).getFullName()));
		}
		return Response.ok(avm).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getAuthorById(@PathParam("id") int id) {
		System.out.println("GETAUTHORBYID GOT CALLED");
		Author a = dao.findById(id);
		AuthorViewModel avm = new AuthorViewModel(a.getId(), a.getFullName());
		return Response.ok(avm).build();
	}

	@POST
	public Response create(Author entity) {
		System.out.println("AUTHORCONTROLLER POST CALLED");
		dao.saveAuthor(entity);
		return Response.status(201).entity(entity).build();
	}
	 
	@PUT
	@Path("{id}")
	public Response update(@DefaultValue("0") @PathParam("id") int id, Author entity) { //
		Author objectToBeChanged = dao.findById(id);
		objectToBeChanged.setFullName(entity.getFullName());
		dao.updateAuthor(objectToBeChanged);
		return Response.status(200).entity(entity).build();
	}		
	
	@DELETE
	@Path("{id}")
	public Response delete(@DefaultValue("0") @PathParam("id") int id) {
		System.out.println("AUTHORCONTROLLER DELETE CALLED");
		Author objectToBeDeleted = dao.findById(id);
		dao.deleteAuthor(objectToBeDeleted);
		return Response.status(200).entity(objectToBeDeleted).build();
	}	
}
