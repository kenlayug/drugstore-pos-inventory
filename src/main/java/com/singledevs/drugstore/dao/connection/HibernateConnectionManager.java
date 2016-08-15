package com.singledevs.drugstore.dao.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConnectionManager implements ConnectionManager{

	private SessionFactory sessionFactory;
	
	public void establishConnection() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
		
			if (sessionFactory == null){
				
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
				
			}//end if
			
		}catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
		}//end try catch
		
	}//end establishConnection

	public void stopConnection() {
		// TODO Auto-generated method stub
		
	}
	
	public SessionFactory getSessionFactory(){
		
		return this.sessionFactory;
		
	}

}
