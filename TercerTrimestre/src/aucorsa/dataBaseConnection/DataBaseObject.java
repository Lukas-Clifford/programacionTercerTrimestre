package aucorsa.dataBaseConnection;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseObject {
	
	protected HashMap<String,Object> columnsMap = new HashMap<String, Object>();
	protected ArrayList<Object> columnsArray = new ArrayList<Object>();
	
	public String toString() {
		return this.columnsArray.toString();
	}
	
	public Object getColumn(int columnIndex) {
		return this.columnsArray.get(columnIndex);	
	}
	
	public Object getColumn(String column) {
		return this.columnsMap.get(column);
	}
	
}
