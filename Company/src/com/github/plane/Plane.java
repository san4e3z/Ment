package com.github.plane;

public class Plane implements Comparable {
	
	private String name;
	private int capacity;
	private int carryingCapacity;
	private int flightRange;
	
	public Plane(String name, int capacity, int carryingCapacity,
			int flightRange) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.carryingCapacity = carryingCapacity;
		this.flightRange = flightRange;
	}
	
	@Override
	public String toString() {
		return "Plane ( " + name + " , " + capacity + " peoples " + carryingCapacity + " kg " + flightRange + " km )";
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
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int get�arryingCapacity() {
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
