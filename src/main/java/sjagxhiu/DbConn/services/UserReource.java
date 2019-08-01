package sjagxhiu.DbConn.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sjagxhiu.DbConn.JPA.UserORM;
import sjagxhiu.DbConn.jackson.JsonWriter;
import sjagxhiu.DbConn.jaxb.XMLWriter;
import sjagxhiu.DbConn.model.UserJPA;
import sjagxhiu.DbConn.model.Users;

@Path("users")
public class UserReource {

	EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("jpa_unit");
	EntityManager em = emf.createEntityManager();
	UserORM orm = new UserORM(em);
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAll() {		
		try {
			List<UserJPA> list = orm.getAll();
			Users users = new Users();
			users.setUsers(list);
			String xml = XMLWriter.writeAndGetString(null, users);
			return Response.status(200).entity(xml).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJson() {		
		try {
			List<UserJPA> list = orm.getAll();
			Users users = new Users();
			users.setUsers(list);
			String json = JsonWriter.writeAndGetString(null, users);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		}	
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByIdAsJson(@PathParam("id") Long id) {
		try {
			UserJPA user = orm.getById(id);
			String json = JsonWriter.writeAndGetString(null, user);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		}	
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getByIdAsXml(@PathParam("id") Long id) {
		try {
			UserJPA user = orm.getById(id);
			String json = XMLWriter.writeAndGetString(null, user);
			return Response.status(200).entity(json).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		}	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(UserJPA user) {
		try {
			orm.insert(user);
			return Response.status(201).entity(
					user.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		} 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response insertAsXML(UserJPA user) {
		try {
			orm.insert(user);
			return Response.status(201).entity(
					user.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("SERVER ERROR").build();
		} 
	}
	
	
}
