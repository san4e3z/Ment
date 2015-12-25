package com.github.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.plane.*;

public class PlaneTest extends BaseClassTest {
	
	protected Plane plane;
	String testName = "TestPlane";
	int testNumber1 = 10;
	int testNumber2 = 100;
	int testNumber3 = 1000;
	
	@BeforeClass
	public void setUpPlaneTest() {
		plane = new Plane(testName, testNumber1, testNumber2, testNumber3);
	}
	
	@Test
	public void checkNameOfPlane () {
		assertEquals(plane.getName(), testName, "Invalid name of plane");
	}
	
	@Test
	public void checkCapacityOfPlane () {
		assertEquals(plane.getCapacity(), testNumber1, "Invalid capacity of plane");
	}
	
	@Test
	public void checkCarryingCapacityOfPlane () {
		assertEquals(plane.get—arryingCapacity(), testNumber2, "Invalid carrying capacity of plane");
	}
	
	@Test
	public void checkFlightRangeOfPlane () {
		assertEquals(plane.getFlightRange(), testNumber3, "Invalid flight range of plane");
	}
}
