package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.hibernate.entities.ProductEntity;
import org.studyeasy.showroom.service.ProductsService;

//@Path("/showroom/brands")
public class Products {
	ProductsService productsService = new ProductsService();
	
	
	@GET  // specifies the type of request to be handled
	@Produces(MediaType.APPLICATION_JSON) //Specifies the type of media the method will return, MediaType.APPLICATION_XML for XML response
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId,
												  @QueryParam("category") String category) {
		
		List<ProductEntity> productsList;
		if(category != null) {  //Filtering the data based on the category
			productsList = productsService.getProductsByBrandAndCatgory(brandId, category);
			return productsList;
		}else {
			productsList = productsService.getProductsByBrand(brandId);
			return productsList;
		}
		
	}
}
