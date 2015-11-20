package com.github.exceptions;

public class PrintListOfPlanesException extends Exception{
	
	public PrintListOfPlanesException() {
		 System.out.println("List of planes is empty");
	}

}
