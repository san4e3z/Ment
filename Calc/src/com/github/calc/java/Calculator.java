package com.github.calc.java;

import java.util.Scanner;


public class Calculator {

	private static void display(double first, double second, String act, double res) {
		
		System.out.println(first + " " + act + " " + second + " = " + res);
		
	}
	public static void main(String[] args) {
		
		double result = 0;
		boolean next = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (next) {
			
			System.out.println("Input the 1st argument");
			double firstVar = sc.nextDouble();
			
			System.out.println("Input the 2nd argument");
			double secondVar = sc.nextDouble();
			
			System.out.println("Input the action (+,-,*,/, enter 'Exit' to quit)");
			String action = sc.next();
			
			if ((secondVar == 0) && (action.equals("/"))) {
				System.out.println("Division by zero");
				continue;
				}
			else if(action.toLowerCase().equals("exit")) {
				next = false;
			} else {
				switch (action) {
				case "+":
					result = firstVar + secondVar;;
					break;
				case "-":
					result = firstVar - secondVar;
					break;
				case "*":
					result = firstVar * secondVar;
					break;
				case "/":
					result = firstVar / secondVar;
					break;
				default:
					System.out.println("Wrong input");
					continue;
				}
				display(firstVar, secondVar, action, result);
			}
		}
	}
}
