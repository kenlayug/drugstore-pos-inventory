package com.singledevs.drugstore.dao.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.singledevs.drugstore.model.Product;
import com.singledevs.drugstore.model.ProductPrice;

public class HibernateConnectionManager implements ConnectionManager{

	private SessionFactory sessionFactory;
	
	public void establishConnection() {
		
		StandardServiceRegistry registry = null;
		try {

			InputStream propertiesInputStream = getClass().getClassLoader()
			        .getResourceAsStream("hibernate.properties");
			
			Properties properties = new Properties();
			properties.load(propertiesInputStream);
			
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml").addProperties(properties);
			
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(ProductPrice.class);
			
			registry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.configure()
					.build();
			
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
