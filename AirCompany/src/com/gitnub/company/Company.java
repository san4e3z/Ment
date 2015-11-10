package com.gitnub.company;

import com.github.plane.Plane;

public interface Company {
	
	public void addPlane(Plane plane);
	public int totalCapacity();
	public int totalCarryingCapacity();
	public void findPlane(int minFlightRange, int maxFlightRange);
	public void sortPlanes();

}
