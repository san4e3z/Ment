package com.github.runner;


import com.gitnub.company.MyAirCompany;

public class Runner {

	public static void main(String[] args) {
		
		final String NAME = "KLM";
		final int SIZE = 5;
		
		MyAirCompany newCompany =  new MyAirCompany(NAME, SIZE);
		newCompany.printPlaneInfo();
		
		//Total carrying capacity/carrying capacity
		System.out.println("\nTotal capacity of company " + NAME + " " + newCompany.totalCapacity() + " peoples");
		System.out.println("Total carrying capacity of company " + NAME + " " + newCompany.total—arryingCapacity() + " kg\n");
		
		//Sort by flight range
		newCompany.sortPlanes();
		newCompany.printPlaneInfo();
		
		//Find necessary planes by flight range interval
		newCompany.findPlaneByFlightRange();
	}

}
