package com.java.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection conn;

	public Connection connect() {
		try {
			// Informing the connection driver that will be used by the DriveManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Creating a connection with the database
			conn = DriverManager.getConnection("jdbc.oracle:thin:@localhost:1521:xe", "MARCUS", "MARCUS");
			return conn;	
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	public void disconnect() {
		try {
			if (conn != null && !conn.isClosed()) {
				// disconnecting from database
				conn.close();
			}
		} catch (SQLException e) {
		}
	}
}
