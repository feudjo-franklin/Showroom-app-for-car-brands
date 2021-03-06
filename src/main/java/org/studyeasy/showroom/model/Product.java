package org.studyeasy.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="products") // Default name is the name of the class
@Table(name="products") // for connecting to the database table named products
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	//for the connection between the two tables , this will specify Hibernate, that this particular column is a foreign key
	@ManyToOne(targetEntity = Brand.class)  // doesn't work with primitive data type
	@JoinColumn(name="brandId")  // specifies that the brandId needed is inside the object brandEntity 
	private Brand brandEntity;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="cost")
	private String cost;

	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public Brand getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(Brand brandEntity) {
		this.brandEntity = brandEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
}
