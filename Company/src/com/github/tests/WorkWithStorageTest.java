package com.github.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;
import com.github.plane.Plane;

public class WorkWithStorageTest extends BaseClassTest {
		
	@Test
	public void workWithTextFile() throws IOException {
		testCompany.savePlanesFile();
		testPlanes = read.loadFile(testPlanes, "Planes.txt");
		for (int i = 0; i < testPlanes.size(); i++) {
			testUsingRegEx(testPlanes, i);
		}
		clearTestArray(testPlanes);
	}
	
	@Test
	public void loadFromXml() {
		testPlanes = read.loadXML(testPlanes);
		//—heck special element added in the end of the xml file
		testUsingRegEx(testPlanes, testPlanes.size()-1);
		clearTestArray(testPlanes);
	}
	
	@Test
	public void workWithDB() throws ClassNotFoundException, SQLException {
		testCompany.savePlanesDb();
		testPlanes = read.loadSQLite(testPlanes);
		for (int i = testPlanes.size() - TESTNUMBEROFPLANES; i < testPlanes.size(); i++) {
			testUsingRegEx(testPlanes, i);
		}
		clearTestArray(testPlanes);
	}
	
	public void testUsingRegEx(ArrayList<Plane> testPlanes, int index) {
		assertEquals(testSpecificNameOfPlane(testPlanes.get(index).getName()), true, "Invalid name of the company");
		assertEquals(testNumeralsOfPlane(testPlanes.get(index).getCapacity()), true, "Invalid capacity of the company");
		assertEquals(testNumeralsOfPlane(testPlanes.get(index).get—arryingCapacity()), true, "Invalid carrying capacity of the company");
		assertEquals(testNumeralsOfPlane(testPlanes.get(index).getFlightRange()), true, "Invalid flight range of the company");
	}
	
	public static boolean testSpecificNameOfPlane(String testString){  
        Pattern p = Pattern.compile("^" + TESTNAMEOFCOMPANY + "\\d+$");  
        Matcher m = p.matcher(testString);
        return m.matches();
    }
	
	public static boolean testNumeralsOfPlane(int testNumber){
		String testString = Integer.toString(testNumber);
        Pattern p = Pattern.compile("^\\d+$");  
        Matcher m = p.matcher(testString);  
        return m.matches();
	}
}
