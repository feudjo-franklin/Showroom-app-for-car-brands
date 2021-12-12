package org.studyeasy.showroom.service;

import java.util.List;

import org.studyeasy.showroom.hibernate.DAO.BrandsDAO;
import org.studyeasy.showroom.hibernate.entities.BrandEntity;

public class BrandsService {

	BrandsDAO DAO = new BrandsDAO();
	
	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = DAO.getBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
		
	}

	public void updateBrand(BrandEntity updatedBrand) {
		DAO.updateBrand(updatedBrand);
		
	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
		
	}

	public BrandEntity getBrand(int brandId) {
		return DAO.getBrand(brandId);
	}

}
