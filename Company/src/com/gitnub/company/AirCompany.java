package com.gitnub.company;

import com.github.plane.Plane;

public interface AirCompany {
	
	public int totalCapacity();
	public int total—arryingCapacity();
	public void findPlane(int minFlightRange, int maxFlightRange);
	public void sortPlanes();
	public void addPlane (Plane plane);
	public void fillAirCompany();

}
