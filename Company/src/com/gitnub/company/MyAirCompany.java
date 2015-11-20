package com.gitnub.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import com.github.plane.Plane;
import com.github.plane.PassengerPlane;
import com.github.plane.CargoPlane;
import com.github.exceptions.*;

public class MyAirCompany implements AirCompany  {
	
	final static int TYPEOFPLANE = 2;
	final static int SIZEOFRANDOMARG1 = 100;
	final static int SIZEOFRANDOMARG2 = 10;
	final static int MINVALUE = 10000;
	
	private String nameOfCompany;
	private int numberOfPlanes;
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	
	Scanner scan = new Scanner(System.in);
	
	public void createAirCompany () throws SizeOfCompanyException {
		System.out.println("Input name and count of planes for the new air company");
		nameOfCompany = scan.next();
		//built-in exception
		try {
			numberOfPlanes = scan.nextInt();
		} catch(NoSuchElementException  ex1) {
			System.out.println("You don't enter numeric values");
		}
		if (numberOfPlanes > 0) {
			fillAirCompany();			
		} else {
			throw new SizeOfCompanyException();
		}
	}
		
	@Override
	public void addPlane(Plane plane) {
		planes.add(plane);	
	}
	
	public void printPlaneInfo() throws PrintListOfPlanesException {
		if (planes.size() != 0) {
			for (Plane iteratorPlane : planes) {
				System.out.println(iteratorPlane.toString());
			}
		} else {
			throw new PrintListOfPlanesException();			
		}
	}
	
	public void planesInfoPrint(ArrayList<Plane> listOfPlanes){
		for (Plane iteratorPlane : listOfPlanes) {
			System.out.println(iteratorPlane.toString());
		}
	}

	public void fillAirCompany() {
		Random rand = new Random();
		for (int i = 0; i < numberOfPlanes; i++) {
			String nameOfPlane = nameOfCompany.concat(Integer.toString(rand.nextInt(SIZEOFRANDOMARG1)));
			
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
	public int total—arryingCapacity() {
		int total = 0;
		for (Plane iteratorPlane : planes) {
			total+= iteratorPlane.get—arryingCapacity();
		}
		return total;
	}
	
	public int avegageCapacity() {
		int avegage = 0;
		//built-in exception
		try {
			avegage = totalCapacity()/numberOfPlanes;		
		} catch (ArithmeticException ex5) {
			System.out.println("division by zero");
		}
		return avegage;
		
	}

	@Override
	public void findPlane (int minFlightRange, int maxFlightRange) throws FindByFlightRangeException {
		ArrayList<Plane> result = new ArrayList<Plane>();   
        for(Plane plane : planes){
        	if (plane.getFlightRange() >=  minFlightRange && plane.getFlightRange() <= maxFlightRange) {
                    result.add(plane);
            }
        }    
        if (result.size() != 0)  {
        	planesInfoPrint(result);
        } else {
        	throw new FindByFlightRangeException(minFlightRange, maxFlightRange);
        }      
	}

	@Override
	public void sortPlanes() {
		planes.sort(null);
	}

	public void findPlaneByFlightRange() throws FindByFlightRangeException {
		System.out.println("\nInput flight range interval for search");
		int firstVar = 0;
		int secondVar = 0;
		//built-in exception
		try {
			firstVar = scan.nextInt();
			secondVar = scan.nextInt();
		} catch(NoSuchElementException  ex1) {
			System.out.println("You don't enter numeric values");
		}
		
		this.findPlane(firstVar, secondVar);
	}
	
	public void deleteListOfAllPlanes() {
		Iterator<Plane> iter = planes.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}
	
	public void saveFile(String path) {
		File file = new File(path); 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	        try {
	        	for(Plane plane : planes) {
	        		out.println(plane.getName() + ";" + plane.getCapacity() + ";" + plane.get—arryingCapacity() + ";" + plane.getFlightRange());
	        	}
	        } finally {
	        	out.close();
	        }
	    } catch(IOException ex4) {
	    	throw new RuntimeException(ex4);
	    }
	}

	public void loadFile(String path) throws IOException {
		//deleteListOfAllPlanes(planes);

	    FileReader reader = new FileReader(path);
	    BufferedReader buffReader = new BufferedReader(reader);
	    String line = buffReader.readLine();
	    while(line != null) {
	    	//built-in exception
	    	try {
	    		String[] part = line.split(";");
	    		addPlane(new Plane(part[0], Integer.parseInt(part[1]), Integer.parseInt(part[2]), Integer.parseInt(part[3])));
	    	} catch (ArrayIndexOutOfBoundsException ex2) {
	    		System.out.println("Deficiency of information in the row");
	    	} catch (NumberFormatException ex3) {
	    		System.out.println("Non numerical information in the row");
	    	}
	    	line = buffReader.readLine();
	    }
	    buffReader.close();
	    reader.close();
	}
}
