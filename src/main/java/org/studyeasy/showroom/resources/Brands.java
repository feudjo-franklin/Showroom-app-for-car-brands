package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.hibernate.entities.BrandEntity;
import org.studyeasy.showroom.service.BrandsService;

@Path("/showroom/brands")
public class Brands {
	BrandsService service = new BrandsService();
	
	//@Path("")  //  this method handles the url pattern /showroom/brands
	@GET  // specifies the type of request to be handled
	@Produces(MediaType.APPLICATION_JSON) //Specifies the type of media the method will return, MediaType.APPLICATION_XML for XML response
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = service.getBrands();
		return list;
	}
	
	@POST  // specifies the type of request to be handled
	@Consumes(MediaType.APPLICATION_JSON) //Specifies the type of media the method will return, MediaType.APPLICATION_JSON for JSON response
	public void postBrands(BrandEntity brand) {
		service.addBrand(brand);
		
	}
	
	@PUT
	@Path("/{brandId}")  // {} the curly braces informs Jersey that this is a variable
	@Consumes(MediaType.APPLICATION_JSON) 
	public void putBrands(@PathParam("brandId") int brandId, BrandEntity updatedBrand) {  // @PathParam("brandId") to associate the value oF brandId in the URL with the parameter of the method 
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
	public Products productsDelegation() {
		return new Products();
	}
	
}
