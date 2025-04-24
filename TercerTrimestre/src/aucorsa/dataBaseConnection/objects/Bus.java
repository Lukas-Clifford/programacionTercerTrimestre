package aucorsa.dataBaseConnection.objects;

import java.util.List;

import aucorsa.dataBaseConnection.DataBaseObject;

public class Bus extends DataBaseObject{
	
	public Bus (String register, String type, String license) {
		
		this.columnsArray.addAll(List.of(register, type, license));
		
		this.columnsMap.put("register", register);
		this.columnsMap.put("type", type);
		this.columnsMap.put("license", license);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
