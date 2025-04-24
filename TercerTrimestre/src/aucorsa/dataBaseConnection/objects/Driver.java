package aucorsa.dataBaseConnection.objects;

import java.util.List;

import aucorsa.dataBaseConnection.DataBaseObject;

public class Driver extends DataBaseObject {
	
	public Driver (int numdriver, String name, String surname) {
		
		this.columnsArray.addAll(List.of(numdriver, name, surname));
		
		this.columnsMap.put("numdriver", numdriver);
		this.columnsMap.put("name", name);
		this.columnsMap.put("surname", surname);
		
	}

}
