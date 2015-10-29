package com.github.calc.java;

import java.util.Scanner;


public class Calculator {

	private static void display(double first, double second, String act, double res) {
		
		System.out.println(first + " " + act + " " + second + " = " + res);
		
	}
	public static void main(String[] args) {
		
		double result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the 1st argument");
		double firstVar = sc.nextDouble();
		
		System.out.println("Input the 2nd argument");
		double secondVar = sc.nextDouble();
		
		System.out.println("Input the action (+,-,*,/)");
		String action = sc.next();
		
		if ((secondVar == 0) && (action.equals("/"))) {
			System.out.println("Division by zero");
		} else
		{
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
				return;
			}
			display(firstVar, secondVar, action, result);
		}
	}
}
