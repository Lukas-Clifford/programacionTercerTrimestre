package aucorsa;

import aucorsa.dataBaseConnection.DBController;
import aucorsa.dataBaseConnection.objects.Driver;

public class Main {

	public static void main(String[] args) {
		
		DBController c = new DBController();
		c.createConection("Aucorsa");
		
		Driver driver = c.getDriver(101);
		System.out.println(driver);
		
		c.closeConnection();
		
	}

}
