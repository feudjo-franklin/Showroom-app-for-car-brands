package org.studyeasy.showroom.service;

import java.util.List;

import org.studyeasy.showroom.DAO.ProductsDAO;
import org.studyeasy.showroom.model.Product;

public class ProductsService {
	ProductsDAO DAO = new ProductsDAO();
	
	public List<Product> getProductsByBrand(int brandId) {
		List<Product> productsList = DAO.getProductsByBrand(brandId);
		return productsList;
	}

	public List<Product> getProductsByBrandAndCatgory(int brandId, String category) {
		List<Product> productsList = DAO.getProductsByBrandAndCategory(brandId, category);
		return productsList;
	}

}
