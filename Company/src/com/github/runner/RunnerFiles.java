package com.github.runner;

import java.io.IOException;

import com.gitnub.company.MyAirCompany;

public class RunnerFiles {

	public static void main(String[] args) throws IOException {

		final String PATH = "Planes.txt";
		
		//Create 1st aircompany
		MyAirCompany newCompany =  new MyAirCompany();
		newCompany.createAirCompany();
		
		//Create (or rewrite existed) file with info (list of planes) about 1st aircompany
		newCompany.saveFile(PATH);
		
		//Create 2nd aircompany
		MyAirCompany anotherCompany = new MyAirCompany();
		anotherCompany.createAirCompany();
		
		//Read a previously saved file and add information about the 2nd aircompany
		anotherCompany.loadFile(PATH);
		anotherCompany.printPlaneInfo();	

	}

}
