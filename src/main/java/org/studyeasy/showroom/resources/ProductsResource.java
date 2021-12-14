package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.model.Product;
import org.studyeasy.showroom.service.ProductsService;

//@Path("/showroom/brands")
public class ProductsResource {
	ProductsService productsService = new ProductsService();
	
	
	@GET  // specifies the type of request to be handled
	@Produces(MediaType.APPLICATION_JSON) //Specifies the type of media the method will return, MediaType.APPLICATION_XML for XML response
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category, @QueryParam("start") int start,
			@QueryParam("end") int end) { //Default value of int parameter is 0
		
		List<Product> productsList;
		if(category != null) {  //Filtering the data based on the category
			productsList = productsService.getProductsByBrandAndCatgory(brandId, category);
			
		}else {
			productsList = productsService.getProductsByBrand(brandId);
		}
		
		if(end > 0) {
			productsList = productsList.subList(start, end);
		}
		
		return productsList;
	}
}
