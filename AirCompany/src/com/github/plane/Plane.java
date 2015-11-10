package com.github.plane;


public class Plane implements Comparable {
	
	private String name;
	private int capacity;
	private int flightRange;
	private int carryingCapacity;
	private String typePlane;
	
	public Plane(String name, String typePlane, int capacity, int carryingCapacity, int flightRange) {
		this.name = name;
		this.setCapacity(capacity);
		this.setFlightRange(flightRange);
		this.setCarryingCapacity(carryingCapacity);
		this.typePlane = typePlane;
	}
	
	public void planeInfo () {
		System.out.println("Plane " + name + "\t" + typePlane + "\t" + "(capacity : " + getCapacity() 
				+ " peoples; carryingCapacity : " + getCarryingCapacity() + " kg; flightRange : " + getFlightRange() + " km)");
	}
	
	@Override
	public int compareTo(Object obj) {
		Plane tmpPlane = (Plane)obj;
		if(this.flightRange < tmpPlane.flightRange)
		{
			return -1;
		} 
		else if(this.flightRange > tmpPlane.flightRange)
		{
			return 1;
		}
		return 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCarryingCapacity() {
		return carryingCapacity;
	}
	public void setCarryingCapacity(int carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}
	public int getFlightRange() {
		return flightRange;
	}
	public void setFlightRange(int flightRange) {
		this.flightRange = flightRange;
	}
}
