package com.singledevs.drugstore.dao.hibernate;

import org.hibernate.Session;

import com.singledevs.drugstore.dao.ProductRepository;
import com.singledevs.drugstore.dao.connection.HibernateConnectionManager;
import com.singledevs.drugstore.model.Product;

public class HibernateProductRepository extends HibernateClient implements ProductRepository{

	public HibernateProductRepository(HibernateConnectionManager hibernateConnectionManager) {
		super(hibernateConnectionManager);
	}

	public String saveProduct(Product product) {
		
		Session session = null;
		try{
			
			session		=	getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(product);
			session.persist(product.getProductPrice());
			session.flush();
			session.getTransaction().commit();
			return "success";
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}finally{
			
			session.close();
			
		}
		return "error";
		
	}

}
