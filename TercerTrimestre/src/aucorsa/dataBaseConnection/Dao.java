package aucorsa.dataBaseConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import aucorsa.dataBaseConnection.objects.Bus;
import aucorsa.dataBaseConnection.objects.Driver;

public class Dao {
	
	private Connection conn = null;
	
	public Dao() {}

	
	public void createConection(String dataBase) {
		if(checkDriver()) {
			try {
				
				this.conn = DriverManager.getConnection(
						String.format(
								"jdbc:mysql://%s:%d/%s",
								getProperty("host"),
								Integer.parseInt(getProperty("port")),
								dataBase
								),
						getProperty("user"),
						getProperty("pass")
						
						);
				
			} catch (SQLException e) {e.printStackTrace();}
			catch (NumberFormatException e) {System.err.println("port not a Integer");}
		}
	}

	
	private boolean checkDriver() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return true;
			
		}catch (ClassNotFoundException e) {
			System.err.println("Class not found");
			return false;
		
		}
		
	}
	
	
	private String getProperty(String propertyName) {
		
		String propertyValue = "";
		
		try {
			
			Properties properties = new Properties();
			
			properties.load(new FileInputStream("src/aucorsa/config.properties"));
			
			propertyValue = properties.getProperty(propertyName);
			
		} catch (IOException e) {e.printStackTrace();}
		
		return propertyValue;
	}
	

	public void closeConnection() {
		
		try{	this.conn.close();	}
		
		catch (SQLException e){		e.printStackTrace();	}

	}
	
	
	public Driver getDriver(int numdriver) {
		
		Driver driver = null;
		
		try {
			Statement s = this.conn.createStatement();
			
			ResultSet result = s.executeQuery(
					"SELECT * FROM Driver WHERE numdriver = " + numdriver);
			
			result.next();
			driver = new Driver(
					result.getInt(1),
					result.getString(2),
					result.getString(3)
					);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
	
	
public Bus getBus(String register) {
		
	Bus bus = null;
		
		try {
			Statement s = this.conn.createStatement();
			
			ResultSet result = s.executeQuery(
					"SELECT * FROM Driver WHERE numdriver = '" + register + "'");
			
			result.next();
			bus = new Bus(
					result.getString(1),
					result.getString(2),
					result.getString(3)
					);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bus;
	}
	

// TO DO getPlace, getRoute



}
