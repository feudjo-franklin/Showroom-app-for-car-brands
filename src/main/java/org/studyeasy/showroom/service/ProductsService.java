package org.studyeasy.showroom.service;

import java.util.List;

import org.studyeasy.showroom.hibernate.DAO.ProductsDAO;
import org.studyeasy.showroom.hibernate.entities.ProductEntity;

public class ProductsService {
	ProductsDAO DAO = new ProductsDAO();
	
	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productsList = DAO.getProductsByBrand(brandId);
		return productsList;
	}

	public List<ProductEntity> getProductsByBrandAndCatgory(int brandId, String category) {
		List<ProductEntity> productsList = DAO.getProductsByBrandAndCategory(brandId, category);
		return productsList;
	}

}
