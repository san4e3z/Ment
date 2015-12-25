package com.github.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.company.*;
import com.github.exceptions.SizeOfCompanyException;
import com.github.plane.Plane;

public class BaseClassTest {
	
	final static int TESTNUMBEROFPLANES = 3;
	final static String TESTNAMEOFCOMPANY = "TestCompany";
	
	protected MyAirCompany testCompany;
	protected ArrayList<Plane> testPlanes = new ArrayList<Plane>();
	
	Reader read = new Reader();
	
	@BeforeClass
	public void setUp() throws SizeOfCompanyException {
		testCompany = new MyAirCompany();
		testCompany.createAirCompany(TESTNUMBEROFPLANES, TESTNAMEOFCOMPANY);
	}
	
	@AfterClass
	public void close() {
		clearTestArray(testPlanes);
		testCompany.deleteListOfAllPlanes();
	}
	
	public void clearTestArray(ArrayList<Plane> testArray) {
		Iterator<Plane> iter = testArray.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}	

}
