package com.github.runner;

import java.util.Scanner;

import com.gitnub.company.*;

public class TestApp {
	
	public static void main(String[] args) {
		//Create and fill aircompany
		String nameOfCompany = "KLM";
		AirCompany newCompany = new AirCompany();
		newCompany.fillAirCompany(7, nameOfCompany);
		
		//Print info about planes and its parameters
		System.out.println("Planes of aircompany " + nameOfCompany);
		newCompany.companyInfoPrint();
		
		//Input total capacity and total carrying capacity
		System.out.println("\nTotal capacity of aircompany " + nameOfCompany + " = " + newCompany.totalCapacity() + " peoples");
		System.out.println("Total carrying capacity of aircompany " + nameOfCompany + " = " 
				+ newCompany.totalCarryingCapacity() + " kg\n");
		
		//Sort by flight range and input info about planes
		newCompany.sortPlanes();
		System.out.println("Planes of aircompany " + nameOfCompany + " after sorting by ");
		newCompany.companyInfoPrint();
		
		//Find necessary planes by flight range interval
		System.out.println("\nInput flight range interval for search");
		Scanner sc = new Scanner(System.in);
		int firstVar = sc.nextInt();
		int secondVar = sc.nextInt();
		
		newCompany.findPlane(firstVar, secondVar);
		sc.close();
	}

}
