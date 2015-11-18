package com.github.runner;

import com.gitnub.company.MyAirCompany;

public class Runner {

	public static void main(String[] args) {
		
		MyAirCompany newCompany =  new MyAirCompany();
		newCompany.createAirCompany();
		newCompany.printPlaneInfo();
		
		//Total carrying capacity/carrying capacity
		System.out.println("\nTotal capacity of company " + newCompany.totalCapacity() + " peoples");
		System.out.println("Total carrying capacity of company " + newCompany.total—arryingCapacity() + " kg\n");
		
		//Sort by flight range
		newCompany.sortPlanes();
		newCompany.printPlaneInfo();
		
		//Find necessary planes by flight range interval
		newCompany.findPlaneByFlightRange();
	}

}
