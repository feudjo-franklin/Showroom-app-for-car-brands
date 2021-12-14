package org.studyeasy.showroom.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.model.Brand;
import org.studyeasy.showroom.model.Product;

public class ProductsDAO {
	
	SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Product.class)
									.addAnnotatedClass(Brand.class)
									.buildSessionFactory();

	public List<Product> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Product> productsList;
		String HQL = "from products where brandId = '" + brandId + "'";
		productsList = session.createQuery(HQL).getResultList();
		return productsList;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Product> productsList;
		String HQL = "from products where brandId = '" + brandId + "' and category = '" + category + "'";
		productsList = session.createQuery(HQL).getResultList();
		return productsList;
	}
	
}
