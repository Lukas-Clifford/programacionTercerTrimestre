package aucorsa.dataBaseConnection.objects;

import java.util.List;

import aucorsa.dataBaseConnection.DataBaseObject;

public class Route extends DataBaseObject{

	public Route(String register, int numdriver, int idplace, String dayOfWeek) {
		
		this.columnsArray.addAll(List.of(register, numdriver, idplace, dayOfWeek));
		
		this.columnsMap.put("register", register);
		this.columnsMap.put("numdriver", numdriver);
		this.columnsMap.put("idplace", idplace);
		this.columnsMap.put("dayOfWeek", dayOfWeek);
		
	}
	
}
