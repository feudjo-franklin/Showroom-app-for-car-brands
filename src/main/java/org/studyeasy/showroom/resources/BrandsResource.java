package org.studyeasy.showroom.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.studyeasy.showroom.model.Brand;
import org.studyeasy.showroom.service.BrandsService;

@Path("/showroom/brands") 
public class BrandsResource {
	BrandsService service = new BrandsService();
	
	//@Path("")  //  this method handles the url pattern /showroom/brands
	@GET  // specifies the type of request to be handled
	@Produces(MediaType.APPLICATION_JSON) //Specifies the type of media the method will return, MediaType.APPLICATION_XML for XML response
	public List<Brand> getBrands() {
		List<Brand> list = service.getBrands();
		return list;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{brandId}")
	public Brand getBrands(@PathParam("brandId") int brandId) {
		
		return service.getBrand(brandId);
	}
	
	@POST  // specifies the type of request to be handled
	@Consumes(MediaType.APPLICATION_JSON) //Consumes annotation because the method will consume the database, MediaType.APPLICATION_JSON for JSON response
	@Produces(MediaType.APPLICATION_JSON) // MediaType.APPLICATION_JSON because the response is an object
	public Response postBrands(Brand brand, @Context UriInfo uri) {
		
		service.addBrand(brand);
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build(); //Building the URI with the brandId at the end
		return Response.created(location).entity(brand).build();
				//status(Status.CREATED).entity(brand).build();  //entity() method for displaying the response on the page
	}
	
	@PUT
	@Path("/{brandId}")  // {} the curly braces informs Jersey that this is a variable
	@Consumes(MediaType.APPLICATION_JSON) 
	public void putBrands(@PathParam("brandId") int brandId, Brand updatedBrand) {  // @PathParam("brandId") to associate the value oF brandId in the URL with the parameter of the method 
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/{brandId}") 
	public void deleteBrands(@PathParam("brandId") int brandId) {
		
		service.deleteBrand(brandId);
	}
	
	//We delegate the call of the different brand's products to the subresource class Products 
	@Path("/{brandId}/products")
	public ProductsResource productsDelegation() {
		return new ProductsResource();
	}
	
}
