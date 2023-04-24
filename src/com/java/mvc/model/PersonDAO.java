package com.java.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PersonDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean insertPerson(Person person1) {
		DBConnection connection = new DBConnection();
		conn = connection.connect();
		if (conn == null) {
			connection.disconnect();
			return false;
		}
		try {
			// Opening the connection with the database
			// Instantiating the preparedStatement object
			String insert = "INSERT INTO PERSON (PERSONID, NAME, AGE,"
					+ "WEIGHT, GENDER, STATE, MUSIC, MOVIES, READING, SPORTS) "
					+ "VALUES (PERSONID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(insert);
			// Assigning the values to the parameters
			ps.setString(1, person1.getName());
			ps.setInt(2, person1.getAge());
			ps.setDouble(3, person1.getHeight());
			ps.setDouble(4, person1.getWeight());
			ps.setString(5, person1.getGender());
			ps.setString(6, person1.getFrom());
			ps.setInt(7, 0);
			ps.setInt(8, 0);
			ps.setInt(9, 0);
			ps.setInt(10, 0);
			// Executing the SQL command of the preparedStatement object
			ps.execute();
			// Closing the connection with the database
			connection.disconnect();
			return true;
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR ON INSERTING", 0);
			// Closing the connection with the database
			connection.disconnect();
			return false;
		}
	}
	
	public boolean alterAge(String name, int age) {
		DBConnection connection = new DBConnection();
		conn = connection.connect();
		if (conn == null) {
			connection.disconnect();
			return false;
		}
		try {
			// Opening the connection with the database
			// Instantiating the preparedStatement object
			String alter = "UPDATE PERSON SET AGE = ? WHERE NAME = '" + name + "'";
			ps = conn.prepareStatement(alter);
			// Assigning the value to the parameter
			ps.setInt(1, age);
			//ps.setString(2, name);
			// Executing the SQL connection of the preparedStatement object
			ps.execute();
			if (ps.getUpdateCount() == 0){
				connection.disconnect();
				return false;
			}
			// Closing the connection with the database
			connection.disconnect();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR ALTERING", 0);
			// Closing the connection with the database
			connection.disconnect();
			return false;
		}
	}
	
	public boolean removePerson(String name) {
		DBConnection connection = new DBConnection();
		conn = connection.connect();
		if (conn == null) {
			connection.disconnect();
			return false;
		}
		try {
			// Opening the connection with the database
			// Instantiating the preparedStatement object
			String remove = "DELETE FROM PERSON WHERE NAME = '" + name + "'";
			ps = conn.prepareStatement(remove);
			// Assigning the value to the parameter
			//ps.setString(1, name);
			// Executing the SQL command of the preparedStatement object
			ps.execute();
			if (ps.getUpdateCount() == 0) {
				connection.disconnect();
				return false;
			}
			// Closing the connection with the database
			connection.disconnect();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR REMOVING", 0);
			// Closing the connection with the database
			connection.disconnect();
			return false;
		}
	}
	
	public ResultSet searchAllPeople() {
		DBConnection connection = new DBConnection();
		conn = connection.connect();
		if (conn == null) {
			connection.disconnect();
			return null;
		}
		try {
			// Opening the connection with the database
			// Instantiating the preparedStatement object
			ps = conn.prepareStatement("SELECT * FROM PERSON ORDER BY NAME");
			// Executing the sql command on the preparedStatement object and storing
			// it on the ResultSet
			rs = ps.executeQuery();
			//connection.disconnect();
			// Returning the ResultSet
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR LISTING", 0);
			//connection.disconnect();
			return null;
		}
	}
}
