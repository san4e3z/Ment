package com.github.storage;

import java.sql.SQLException;
import java.util.ArrayList;

import com.github.plane.Plane;

public interface Storage {
	
	public ArrayList<Plane> loadFromStorage(ArrayList<Plane> List) throws ClassNotFoundException, SQLException;
	public void saveInStorage (ArrayList<Plane> listOfPlanes) throws SQLException;
}
