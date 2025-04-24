package aucorsa.dataBaseConnection.objects;

import java.util.List;

import aucorsa.dataBaseConnection.DataBaseObject;

public class Place extends DataBaseObject {
	
	public Place (int idPlace, String cp, String city, String site) {
		
		this.columnsArray.addAll(List.of(idPlace, cp, city, site));
		
		this.columnsMap.put("idplace", idPlace);
		this.columnsMap.put("cp", cp);
		this.columnsMap.put("city", city);
		this.columnsMap.put("site", site);
		
	}

}
