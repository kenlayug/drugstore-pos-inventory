package com.singledevs.drugstore.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tblProductPrice")
public class ProductPrice {

	@Id @GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="intProductPriceId")
	private int intProductPriceId;
	
	@ManyToOne
	@JoinColumn(name="intProductId", foreignKey=@ForeignKey(name="intProductIdFK"))
	private Product product;
	
	@Column(name="deciPrice")
	private BigDecimal deciPrice;
	
	@Version
	private Date dateVersion;

	public ProductPrice(BigDecimal deciPrice, Product product){
		
		this.product		=	product;
		this.deciPrice		=	deciPrice;
		
	}
	
	public int getIntProductPriceId() {
		return intProductPriceId;
	}

	public void setIntProductPriceId(int intProductPriceId) {
		this.intProductPriceId = intProductPriceId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getDeciPrice() {
		return deciPrice;
	}

	public void setDeciPrice(BigDecimal deciPrice) {
		this.deciPrice = deciPrice;
	}

	public Date getDateVersion() {
		return dateVersion;
	}

	public void setDateVersion(Date dateVersion) {
		this.dateVersion = dateVersion;
	}
	
}
