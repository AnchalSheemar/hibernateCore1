package com.nucleus.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class DBConnection {
		Connection connection;
		public Connection createDBConnection()
		{		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");		
			connection=DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
}
