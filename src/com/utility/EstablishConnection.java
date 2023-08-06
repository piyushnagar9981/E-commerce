package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {

	public static java.sql.Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/E_Commerce","root","Vedikamishra@123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
  