package com.singledevs.drugstore.dao.connection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HibernateConnectionManagerTest extends TestCase {

	public HibernateConnectionManagerTest(String testName){
		super(testName);
	}
	
	public void testEstablishConnection() throws Exception{
		
		HibernateConnectionManager mybatisConnectionManager = new HibernateConnectionManager();
		mybatisConnectionManager.establishConnection();
		assertNotNull(mybatisConnectionManager.getSessionFactory());
		
	}
	
	public static Test suite(){
		
		TestSuite suite = new TestSuite();
		suite.addTest(new HibernateConnectionManagerTest("testEstablishConnection"));
		return suite;
		
	}
	
}
