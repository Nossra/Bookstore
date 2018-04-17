package com.nosslin.Bookstore.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nosslin.Bookstore.entities.TokenObject;
import com.nosslin.Bookstore.entities.User;
import com.nosslin.Bookstore.services.user.UserService;
import com.nosslin.Bookstore.utilities.TokenIssuer;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
	private TokenIssuer tokenIssuer;
	private UserService userService;
	
	public UserController() {
		this.tokenIssuer = new TokenIssuer();
		this.userService = new UserService();
	}
		
	@Path("/{login}")
	@POST
	public Response authenticate(User user) {
		boolean valid = userService.login(user.getUsername(), user.getPassword());
		if (valid) {
			String token = tokenIssuer.issueToken(user.getUsername());
			TokenObject obj = new TokenObject(token);
			return Response.ok(obj).build();
		} else {
			System.out.println("Credentials invalid, try again.");
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
}
