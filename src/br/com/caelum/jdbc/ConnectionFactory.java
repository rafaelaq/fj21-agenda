
package br.com.caelum.jdbc;

import java.sql.*;
public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 return DriverManager.getConnection("jdbc:mysql://localhost:3306/jf21", "root", "");
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	}
}