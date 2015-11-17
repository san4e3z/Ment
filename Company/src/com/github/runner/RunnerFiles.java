package com.github.runner;

import java.io.IOException;

import com.gitnub.company.MyAirCompany;

public class RunnerFiles {

	public static void main(String[] args) throws IOException {
		
		final String NAME1 = "AZA";
		final String NAME2 = "QANTAS";
		
		final int SIZE = 5;
		final String PATH = "Planes.txt";
		
		//Create 1st aircompany
		MyAirCompany newCompany =  new MyAirCompany(NAME1, SIZE);
		
		//Create (or rewrite existed) file with info (list of planes) about 1st aircompany
		newCompany.saveFile(PATH);
		
		//Create 2nd aircompany
		MyAirCompany anotherCompany = new MyAirCompany(NAME2, SIZE - 3);
		
		//Read a previously saved file and add information about the 2nd aircompany
		anotherCompany.loadFile(PATH);
		anotherCompany.printPlaneInfo();	

	}

}
