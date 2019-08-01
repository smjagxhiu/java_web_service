package sjagxhiu.DbConn.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloAsText() {
		return "Hello rest service";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response helloASXML() {
		String xml = "<Hello>Hello from jersey</Hello>";
		return Response.status(200).entity(xml).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloASJson() {
		String json = "{\"hello\" : \"hello from jersey\"}";
		return Response.status(200).entity(json).build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response insert(String text) {
		System.out.println(text + " is received");
		return Response.status(201).
				entity(text + " is received").build();
	}
}
