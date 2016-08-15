package com.singledevs.drugstore.dao.hibernate;

import java.math.BigDecimal;

import com.singledevs.drugstore.dao.connection.HibernateConnectionManager;
import com.singledevs.drugstore.model.Product;
import com.singledevs.drugstore.model.ProductPrice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HibernateProductRepositoryTest extends TestCase{

	public HibernateProductRepositoryTest(String testName){
		super(testName);
	}
	
	public void testSaveProduct() throws Exception{
		
		HibernateConnectionManager hibernateConnectionManager = new HibernateConnectionManager();
		hibernateConnectionManager.establishConnection();
		
		HibernateProductRepository hibernateProductRepository = new HibernateProductRepository(hibernateConnectionManager);
		
		Product product = new Product(
				"Shampoo",
				"ProductDescription"
				);
		
		ProductPrice productPrice = new ProductPrice(new BigDecimal(200.00), product);
		product.setProductPrice(productPrice);
		assertEquals("success", hibernateProductRepository.saveProduct(product));
		
	}
	
	public static Test suite(){
		
		TestSuite suite = new TestSuite();
		suite.addTest(new HibernateProductRepositoryTest("testSaveProduct"));
		return suite;
		
	}
	
}
