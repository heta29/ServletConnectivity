package com.ecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	 
		
		private Connection connection;
		public DBConnection(String dbUrl, String username, String password) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.driver");
			this.connection=DriverManager.getConnection(dbUrl,username,password);
			
			
		}
		
		public Connection getconnection()
		{
			return this.connection;
			
		}
		
		public void closeConection() throws SQLException {
			this.connection.close();
		}
		
		
		
		
	}
	


