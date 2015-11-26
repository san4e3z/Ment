package com.github.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.plane.Plane;
import com.github.storage.SQLiteStorage;
import com.github.storage.XMLStorage;

public class Reader {
	
	XMLStorage xml = new XMLStorage();
	SQLiteStorage sqlite = new SQLiteStorage();
	
	public ArrayList<Plane> loadXML(ArrayList<Plane> listFromStorage) {		
		listFromStorage = xml.loadFromStorage(listFromStorage);
		return listFromStorage;
	}
	
	public ArrayList<Plane> loadSQLite(ArrayList<Plane> listFromDb) throws ClassNotFoundException, SQLException {
		sqlite.connect();
		listFromDb = sqlite.loadFromStorage(listFromDb);
		sqlite.closeDB();
		return listFromDb;
	}
	
	public ArrayList<Plane> loadFile(ArrayList<Plane> listFromFile, String path) throws IOException {
	    FileReader reader = new FileReader(path);
	    BufferedReader buffReader = new BufferedReader(reader);
	    String line = buffReader.readLine();
	    while(line != null) {
	    	//built-in exception
	    	try {
	    		String[] part = line.split(";");
	    		listFromFile.add(new Plane(part[0], Integer.parseInt(part[1]), Integer.parseInt(part[2]), Integer.parseInt(part[3])));
	    	} catch (ArrayIndexOutOfBoundsException ex2) {
	    		System.out.println("Deficiency of information in the row");
	    	} catch (NumberFormatException ex3) {
	    		System.out.println("Non numerical information in the row");
	    	}
	    	line = buffReader.readLine();
	    }
	    buffReader.close();
	    reader.close();
	    return listFromFile;
	}
	
	public void createSQLiteFile() throws ClassNotFoundException, SQLException {
		sqlite.connect();
		sqlite.createTable();
		sqlite.closeDB();
	}
	
	public void outputXMLFile() {
		xml.outputXML();
	}
}
