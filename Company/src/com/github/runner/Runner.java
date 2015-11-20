package com.github.runner;

import java.io.IOException;

import com.github.exceptions.*;
import com.gitnub.company.MyAirCompany;

public class Runner {

	public static void main(String[] args) throws SizeOfCompanyException, IOException {
		
		final String PATH = "ListOfPlanes"; 
		
		MyAirCompany Company = new MyAirCompany();
		Company.createAirCompany();
		Company.saveFile(PATH);
		
		MyAirCompany anotherCompany = new MyAirCompany();
		anotherCompany.createAirCompany();
		anotherCompany.loadFile(PATH);
		try {
			anotherCompany.printPlaneInfo();
		} catch (PrintListOfPlanesException e) {
			e.printStackTrace();
		}
	}

}
