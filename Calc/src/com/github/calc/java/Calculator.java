package com.github.calc.java;

import java.util.Scanner;


public class Calculator {

	public static void display(double first, double second, String action, double result) {
		
		System.out.println(first + " " + action + " " + second + " = " + result);
		
	}
	public static void main(String[] args) {
		
		double result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input the 1st argument");
		double first_var = sc.nextDouble();
		
		System.out.println("Input the 2nd argument");
		double second_var = sc.nextDouble();
		
		System.out.println("Input action (+,-,*,/)");
		String action = sc.next();
		
		if ((second_var == 0) && (action.equals("/"))) {
			System.out.println("Division by zero");
		} else
		{
		
			switch (action) {
			case "+":
				result = first_var + second_var;
				display(first_var, second_var, action, result);
				break;
			case "-":
				result = first_var - second_var;
				display(first_var, second_var, action, result);
				break;
			case "*":
				result = first_var * second_var;
				display(first_var, second_var, action, result);
				break;
			case "/":
				result = first_var / second_var;
				display(first_var, second_var, action, result);
					break;
			default:
				System.out.println("Wrong input");
				break;
			}
		}

	}

}
