package com.github.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.plane.Plane;
import com.github.storage.SQLiteStorage;

public class Writer {
	
	SQLiteStorage sqlite = new SQLiteStorage();
	
	public void saveFile(ArrayList<Plane> listToFile, String path) {
		File file = new File(path); 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	        try {
	        	for(Plane plane : listToFile) {
	        		out.println(plane.getName() + ";" + plane.getCapacity() + ";" + plane.get—arryingCapacity() + ";" + plane.getFlightRange());
	        	}
	        } finally {
	        	out.close();
	        }
	    } catch(IOException ex4) {
	    	throw new RuntimeException(ex4);
	    }
	}
	
	public void saveDb(ArrayList<Plane> listToFile) throws ClassNotFoundException, SQLException {
		sqlite.connect();
		sqlite.createTable();
		sqlite.saveInStorage(listToFile);
		sqlite.closeDB();
	}


}
