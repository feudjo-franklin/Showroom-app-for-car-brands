package org.studyeasy.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// add @XmlRootElement when xml response is awaited, annotation is optional for JSON response
@Entity(name="brands")
@Table(name="brands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This annotation will tell Hibernate, that this value will be automatically generated based on the primary key of the table
	@Column(name="brandId")		//it means ,the setter method is called in background to set the value of attribut based on the database whenever we add a row into the table or list the table
	private int brandId;
	
	@Column(name="brandName")
	private String brandName;
	
	@Transient  // To stop Hibernate to map this attribut with a column in the database table brands
	private Link links;
	
	public Brand() {
	
	}

	public Brand(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Link getLinks() {
		return links;
	}

	public void setLinks(Link links) {
		this.links = links;
	}
	
	
}
