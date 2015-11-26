package com.github.storage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.plane.Plane;

public class SQLiteStorage implements Storage {
	
	public Connection conn;
	public Statement statmt;
	public PreparedStatement prep;
	public ResultSet resSet;
	
	public void connect() throws ClassNotFoundException, SQLException {
		conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:DB3.db");
		statmt = conn.createStatement();
			
	}
	
	public void createTable() throws SQLException {
		statmt.execute("CREATE TABLE if not exists 'T_PLANES'"
				+ "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'capacity' INTEGER, 'carrycapacity' INTEGER, 'flightrange' INTEGER);");
	}
	
	public void insert(String name, int cap, int carcap, int frange) throws SQLException {
		prep = conn.prepareStatement("insert into T_PLANES values (?, ?, ?, ?, ?);");
		prep.setString(2, name);
		prep.setString(3, Integer.toString(cap));
		prep.setString(4, Integer.toString(carcap));
		prep.setString(5, Integer.toString(frange));
		prep.addBatch();
		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		prep.close();
	}
	
	public void deleteTable() throws SQLException {
		statmt.execute("delete from 'T_PLANES';");
	}
	
	public void dropTable() throws SQLException {
		statmt.execute("drop table 'T_PLANES';");
	}
	
	public void closeDB() throws SQLException {
		conn.close();
		//statmt.close();
	}
	
	
	@Override
	public ArrayList<Plane> loadFromStorage(ArrayList<Plane> ListForDB) throws SQLException {
		resSet = statmt.executeQuery("select * from T_PLANES;");
		while (resSet.next()) {
			Plane newPlane = new Plane(resSet.getString("name"),resSet.getInt("capacity"),resSet.getInt("carrycapacity"),resSet.getInt("flightrange"));
			ListForDB.add(newPlane);
			System.out.println(newPlane.toString());
		}
		resSet.close();
		return ListForDB;
	}

	@Override
	public void saveInStorage(ArrayList<Plane> listOfPlanes) throws SQLException {
		for (Plane iteratorPlane : listOfPlanes) {
			insert(iteratorPlane.getName(), iteratorPlane.getCapacity(), iteratorPlane.get—arryingCapacity(), iteratorPlane.getFlightRange());
		}
	}
}
