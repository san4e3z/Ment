package com.gitnub.company;

import com.github.plane.Plane;
import java.util.ArrayList;

public class AirCompany implements Company {
	
	private ArrayList<Plane> planes = new ArrayList<Plane>();
		
	public void companyInfoPrint(){
		for (Plane iteratorPlane : planes) {
			iteratorPlane.planeInfo();
		}
	}
	
	public void planesInfoPrint(ArrayList<Plane> listOfPlanes){
		for (Plane iteratorPlane : listOfPlanes) {
			iteratorPlane.planeInfo();
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
	public int totalCarryingCapacity() {
		int total = 0;
		for (Plane iteratorPlane : planes) {
			total+= iteratorPlane.getCarryingCapacity();
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
	
	public void fillAirCompany(int count, String code) {
		String randomType="";
		for (int i = 0; i < count; i++) {
			int randomArg = (int)(Math.random() * 10);
			int randomName = (int)(Math.random() * 1000);
			String nameOfPlane = code.concat(Integer.toString(randomName));
			int randomCapacity = 80 + randomArg * 20;
			int randomCarryingCapacity = 5000 + randomArg * 1000;
			int randomFlightRange = 3000 + randomArg * 1000;
			
			int randomTypeGenerator = (int)(Math.random() * 2);
			if (randomTypeGenerator == 1) {
				randomType = "Boing";
			} else {
				randomType = "Airbus";
			}
			
			Plane newPlane = new Plane(nameOfPlane, randomType, randomCapacity, randomCarryingCapacity, randomFlightRange);
			planes.add(newPlane);
		}		
	}

	@Override
	public void sortPlanes() {
		planes.sort(null);
	}

	

}
