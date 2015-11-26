package com.github.runner;

import java.io.IOException;
import java.sql.SQLException;

import com.github.company.MyAirCompany;
import com.github.exceptions.*;

public class Runner {

	public static void main(String[] args) throws SizeOfCompanyException, PrintListOfPlanesException, IOException, ClassNotFoundException, SQLException {
	
		MyAirCompany firstCompany = new MyAirCompany();
		firstCompany.fillAirCompanyListFromXML();
		firstCompany.printPlaneInfo();
		firstCompany.printStructureOfXMLDoc();
		
		MyAirCompany secondCompany = new MyAirCompany();
		secondCompany.createAirCompany(2, "RyanAir");
		secondCompany.savePlanesDb();
		secondCompany.fillAirCompanyListFromDB();
		secondCompany.printPlaneInfo();

	}
}

