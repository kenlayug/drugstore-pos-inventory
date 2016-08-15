package com.singledevs.drugstore.launcher;

import com.singledevs.drugstore.dao.connection.ConnectionManager;
import com.singledevs.drugstore.dao.connection.HibernateConnectionManager;

public class Launcher {

	public static void main(String[]args){
		
		try{
			
			ConnectionManager connectionManager		=	new HibernateConnectionManager();
			connectionManager.establishConnection();
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			
		}//end try catch
		
	}//end void main
	
}//end class
