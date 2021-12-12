package org.studyeasy.showroom.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Demo {
	
	@Context  // The context of the entire application
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	@GET
	public String usefulAnnotations() {
		
		return "Hello Jax-rs";
	}
	
	@GET
	@Path("demo")
	public String contextDemo(@HeaderParam("header") String header) throws Exception  {
		Response response = Response.status(404).entity("The value of custom header not found").build();
		if(header == null) {
			throw new WebApplicationException(response);
		}
		return "The value of custom header value is : " + header;
	}
	
	//****************** OLD CODE IMPLEMENTATION *******************
	
	/*
	@GET
	public String usefulAnnotations(@HeaderParam("HeaderValue") String headerAttrib,
			@CookieParam("_xsrf") String xsrf) {
		
		return "Hello Jax-rx";
		//return "Header Value: " + headerAttrib + " Cookie _xsrf value: " + xsrf;
	}
	*/
	
	
	/*
	@GET
	@Path("demo")
	public String contextDemo(@Context HttpHeaders header) {
		
		
		return header.getRequestHeaders().keySet().toString();
		//return "Absolute Path: " + uriInfo.getAbsolutePath().toString();
	}
	*/
	
	
	
}
