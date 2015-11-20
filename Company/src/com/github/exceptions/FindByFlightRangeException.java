package com.github.exceptions;

public class FindByFlightRangeException extends Exception{
	
	 private int v1;
	 private int v2;
	 public FindByFlightRangeException(int v1, int v2) {
		 this.v1 = v1;
		 this.v2 = v2;
	 }	 
	 public void Message() {
		 System.out.println("There are not planes with flight range " + v1 + " , " + v2);
	 }
}
