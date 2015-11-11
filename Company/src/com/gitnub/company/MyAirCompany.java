package com.gitnub.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.github.plane.Plane;
import com.github.plane.PassengerPlane;
import com.github.plane.CargoPlane;

public class MyAirCompany implements AirCompany {
	
	final static int TYPEOFPLANE = 2;
	final static int SIZEOFRANDOMARG1 = 100;
	final static int SIZEOFRANDOMARG2 = 10;
	final static int MINVALUE = 10000;
	
	private String nameOfCompany;
	private int numberOfPlanes;
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	
	public MyAirCompany (String name, int size) {
		this.nameOfCompany = name;
		this.numberOfPlanes = size;
		fillAirCompany(nameOfCompany, numberOfPlanes);	
	}
	
	@Override
	public void addPlane(Plane plane) {
		planes.add(plane);	
	}
	
	public void printPlaneInfo() {
		for (Plane iteratorPlane : planes) {
			System.out.println(iteratorPlane.toString());
		}
	}
	
	public void planesInfoPrint(ArrayList<Plane> listOfPlanes){
		for (Plane iteratorPlane : listOfPlanes) {
			System.out.println(iteratorPlane.toString());
		}
	}

	public void fillAirCompany(String name, int count) {
		Random rand = new Random();
		for (int i = 0; i < count; i++) {
			String nameOfPlane = name.concat(Integer.toString(rand.nextInt(SIZEOFRANDOMARG1)));
			
			if (rand.nextInt(TYPEOFPLANE) == 1) {
				int randArg = rand.nextInt(SIZEOFRANDOMARG1);
				addPlane(new CargoPlane (nameOfPlane, SIZEOFRANDOMARG2, MINVALUE + randArg * 100, MINVALUE - randArg * 20));
			} else {
				int randArg = rand.nextInt(SIZEOFRANDOMARG1);
				addPlane(new PassengerPlane (nameOfPlane, randArg * 2, MINVALUE + randArg * 10, MINVALUE + randArg * 40));
			}
		}		
	}

	@Override
	public int totalCapacity() {
		int total = 0;
		for (Plane iteratorPlane : planes) {
			total+= iteratorPlane.getCapacity();
		}
		return total;
	}
	
	@Override
	public int totalÑarryingCapacity() {
		int total = 0;
		for (Plane iteratorPlane : planes) {
			total+= iteratorPlane.getÑarryingCapacity();
		}
		return total;
	}

	@Override
	public void findPlane(int minFlightRange, int maxFlightRange) {
		ArrayList<Plane> result = new ArrayList<Plane>();   
        for(Plane plane : planes){
        	if (plane.getFlightRange() >=  minFlightRange && plane.getFlightRange() <= maxFlightRange) {
                    result.add(plane);
            }
        }
        if (result.size() != 0)  {
        	planesInfoPrint(result);
        } else {
        	System.out.println("Planes with flight range [ " + minFlightRange + " ; " + maxFlightRange + " ] are absent");
        }
	}

	@Override
	public void sortPlanes() {
		planes.sort(null);
		
	}

	public void findPlaneByFlightRange() {
		System.out.println("\nInput flight range interval for search");
		Scanner sc = new Scanner(System.in);
		int firstVar = sc.nextInt();
		int secondVar = sc.nextInt();
		this.findPlane(firstVar, secondVar);
		sc.close();	
	}

}
