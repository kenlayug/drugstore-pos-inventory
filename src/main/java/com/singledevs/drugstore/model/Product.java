package com.singledevs.drugstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tblProduct")
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="intProductId")
	private Long intProductId;
	
	@Column(name="strProductName", unique=true, length=50)
	private String strProductName;
	
	@Column(name="strProductDescription")
	private String strProductDescription;
	
	@Transient
	private ProductPrice productPrice;
	
	public Product(){
		
	}
	
	public Product(String strProductName, String strProductDescription){
		
		this.strProductName				=	strProductName;
		this.strProductDescription		=	strProductDescription;
		
	}

	public Long getIntProductId() {
		return intProductId;
	}

	public void setIntProductId(Long intProductId) {
		this.intProductId = intProductId;
	}

	public String getStrProductName() {
		return strProductName;
	}

	public void setStrProductName(String strProductName) {
		this.strProductName = strProductName;
	}

	public String getStrProductDescription() {
		return strProductDescription;
	}

	public void setStrProductDescription(String strProductDescription) {
		this.strProductDescription = strProductDescription;
	}

	public ProductPrice getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
