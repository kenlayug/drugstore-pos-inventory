package com.singledevs.drugstore.dao.hibernate;

import org.hibernate.SessionFactory;

import com.singledevs.drugstore.dao.connection.HibernateConnectionManager;

public abstract class HibernateClient {

	private HibernateConnectionManager hibernateConnectionManager;
	
	public HibernateClient(HibernateConnectionManager hibernateConnectionManager){
		
		this.hibernateConnectionManager = hibernateConnectionManager;
		
	}
	
	public SessionFactory getSessionFactory(){
		
		return this.hibernateConnectionManager.getSessionFactory();
		
	}
	
}
