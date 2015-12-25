package com.github.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.github.company.MyAirCompany;
import com.github.exceptions.FindByFlightRangeException;
import com.github.exceptions.PrintListOfPlanesException;
import com.github.plane.Plane;

public class AnotherMethodsTest extends BaseClassTest {
	
	final static int Range = 10;
	
	//check results of aggregation function
	
	@Test(priority = 0)
	public void checkTotalCapacity() {
		testCompany.deleteListOfAllPlanes();
		testCompany.fillAirCompanyListFromXML();
		testPlanes = read.loadXML(testPlanes);
		assertEquals(testCompany.totalCapacity(), calculationTotalCapacity(testPlanes), "Invalid totalCapacity method");
	}
	
	@Test(priority = 1)
	public void checkTotalCarryingCapacity() {
		assertEquals(testCompany.total—arryingCapacity(), calculationTotalCarryingCapacity(testPlanes), "Invalid total—arryingCapacity method");
	}
	
	@Test(priority = 2)
	public void checkFindPlane() throws FindByFlightRangeException {
		testPlanes.sort(null);
		int maxFlightRangeValue = testPlanes.get(testPlanes.size() - 1).getFlightRange();
		int testValue = testCompany.findPlane(maxFlightRangeValue, maxFlightRangeValue).size();
		assertEquals(testValue, 1, "Invalid findPlane method");
	}
	
	@Test(priority = 3)
	public void checkAverageCapacity() throws PrintListOfPlanesException {
		MyAirCompany testAnotherCompany = new MyAirCompany();
		testAnotherCompany.createAirCompany(0, "TestAggrFunction");
		testAnotherCompany.fillAirCompanyListFromXML();
		assertEquals(testAnotherCompany.avegageCapacity(), calculationAverageCapacity(testPlanes), "Invalid averageCapacity method");
	}
	
	@Test(priority = 4)
	public void checkAddPlane() throws IOException {
		testCompany.addPlane(new Plane(TESTNAMEOFCOMPANY + Integer.toString(Range), Range, Range * 1000, Range * 1000));
		
		testCompany.savePlanesFile();
		testPlanes = read.loadFile(testPlanes, "Planes.txt");
		
		WorkWithStorageTest testClass = new WorkWithStorageTest();
		testClass.testUsingRegEx(testPlanes, testPlanes.size() - 1);
	}

	public int calculationTotalCapacity(ArrayList<Plane> testList) {
		int total = 0;
		for (Plane iteratorPlane : testList) {
			total+= iteratorPlane.getCapacity();
		}
		return total;
	}
	
	public int calculationTotalCarryingCapacity(ArrayList<Plane> testList) {
		int total = 0;
		for (Plane iteratorPlane : testList) {
			total+= iteratorPlane.get—arryingCapacity();
		}
		return total;
	}
	
	public int calculationAverageCapacity(ArrayList<Plane> testList) {
		int average = 0;
		try {
			average = calculationTotalCapacity(testList)/testList.size();		
		} catch (ArithmeticException ex5) {
			System.out.println("division by zero");
		}
		return average;
	}

}
