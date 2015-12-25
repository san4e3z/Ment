package com.github.company;

import java.util.List;

import com.github.exceptions.*;
import com.github.plane.Plane;

public interface AirCompany {
	
	public int totalCapacity();
	public int total—arryingCapacity();
	public List<Plane> findPlane(int minFlightRange, int maxFlightRange) throws FindByFlightRangeException;
	public void sortPlanes();
	public void addPlane(Plane plane);
	public void fillAirCompany();

}
