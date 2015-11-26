package com.github.runner;

import java.io.IOException;
import java.sql.SQLException;

import com.github.company.MyAirCompany;
import com.github.exceptions.*;

public class Runner {

	public static void main(String[] args) throws SizeOfCompanyException, PrintListOfPlanesException, IOException, ClassNotFoundException, SQLException {
		
		final int OLDVALUECAPACITY = 11;
		final int NEWVALUECAPACITY = 12;
	
		MyAirCompany firstCompany = new MyAirCompany();
		firstCompany.fillAirCompanyListFromXML();
		firstCompany.printPlaneInfo();
		firstCompany.printStructureOfXMLDoc();
		
		MyAirCompany secondCompany = new MyAirCompany();
		secondCompany.createAirCompany(2, "EasyJet");
		secondCompany.savePlanesDb();
		//where capacity is OLDVALUECAPACITY increase that up to NEWVALUECAPACITY
		secondCompany.changeValueCapacity(OLDVALUECAPACITY, NEWVALUECAPACITY);
		secondCompany.fillAirCompanyListFromDB();
		secondCompany.printPlaneInfo();
	}
}

