package com.github.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import com.github.plane.Plane;
import com.github.plane.PassengerPlane;
import com.github.plane.CargoPlane;
import com.github.exceptions.*;
import com.github.company.Reader;

public class MyAirCompany implements AirCompany  {
	
	//Parameters for random creation
	final static int TYPEOFPLANE = 2;
	final static int SIZEOFRANDOMARG1 = 100;
	final static int SIZEOFRANDOMARG2 = 10;
	final static int MINVALUE = 10000;
	
	final static String PATH = "Planes.txt";
	
	private String nameOfCompany;
	private int numberOfPlanes;
	private ArrayList<Plane> planes = new ArrayList<Plane>();
	
	Reader read = new Reader();
	Writer write = new Writer();
	
	public ArrayList<Plane> fillAirCompanyListFromXML(){
		planes = read.loadXML(planes);
		return planes;
	}
	
	public ArrayList<Plane> fillAirCompanyListFromFile() throws IOException {
		planes = read.loadFile(planes, PATH);
		return planes;
	}
	
	public ArrayList<Plane> fillAirCompanyListFromDB() throws ClassNotFoundException, SQLException {
		planes = read.loadSQLite(planes);
		return planes;
	}
	
	public void savePlanesFile() {
		write.saveFile(planes, PATH);
	}
	
	public void savePlanesDb() throws ClassNotFoundException, SQLException {
		write.saveDb(planes);
	}
	
	//Output of xml file
	public void printStructureOfXMLDoc () {
		read.outputXMLFile();
	}
	
	public void changeValueCapacity(int oldArg, int newArg) throws ClassNotFoundException, SQLException {
		write.updateCapValue(oldArg, newArg);
	}
	
	public void createAirCompany (int size, String name) {
		this.numberOfPlanes = size;
		this.nameOfCompany = name;
		fillAirCompany();
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
	
	public int avegageCapacity() {
		int avegage = 0;
		//built-in exception
		try {
			avegage = totalCapacity()/planes.size();		
		} catch (ArithmeticException ex5) {
			System.out.println("division by zero");
		}
		return avegage;	
	}

	public void findPlaneByFlightRange() throws FindByFlightRangeException {
		Scanner scan = new Scanner(System.in);
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
		scan.close();
	}
	
	public void deleteListOfAllPlanes() {
		Iterator<Plane> iter = planes.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
	}
	
	@Override
	public void addPlane(Plane plane) {
		planes.add(plane);	
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
	
	@Override
	public List<Plane> findPlane (int minFlightRange, int maxFlightRange) throws FindByFlightRangeException {
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
        return result;
	}

	@Override
	public void sortPlanes() {
		planes.sort(null);
	}
	
}
