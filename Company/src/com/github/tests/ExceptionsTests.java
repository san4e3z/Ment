package com.github.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.github.exceptions.FindByFlightRangeException;
import com.github.exceptions.PrintListOfPlanesException;

public class ExceptionsTests extends BaseClassTest {
	
	@Test(expectedExceptions = PrintListOfPlanesException.class)
	public void checkPrintListOfPlanesException () throws PrintListOfPlanesException {
		testCompany.deleteListOfAllPlanes();
		testCompany.printPlaneInfo();
	}
	
	@Test(expectedExceptions = FindByFlightRangeException.class)
	public void checkFindByFlightRangeException () throws FindByFlightRangeException, PrintListOfPlanesException {
		testCompany.fillAirCompanyListFromXML();
		testPlanes = read.loadXML(testPlanes);
		testPlanes.sort(null);
		int maxFlightRangeValue = testPlanes.get(testPlanes.size() - 1).getFlightRange();
		testCompany.findPlane(maxFlightRangeValue + 1, maxFlightRangeValue + 2);
	}
	
	@Test(expectedExceptions = IOException.class)
	public void checkIOException() throws IOException {
		read.loadFile(testPlanes, "NonExistentFile.txt");
	}
	
}
