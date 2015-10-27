package com.github.calc.java;

import java.util.Scanner;


public class Calculator {

	public static void display(double first, double second, String act, double res) {
		
		System.out.println(first + " " + act + " " + second + " = " + res);
		
	}
	public static void main(String[] args) {
		
		double result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the 1st argument");
		double first_var = sc.nextDouble();
		
		System.out.println("Input the 2nd argument");
		double second_var = sc.nextDouble();
		
		System.out.println("Input the action (+,-,*,/)");
		String action = sc.next();
		
		if ((second_var == 0) && (action.equals("/"))) {
			System.out.println("Division by zero");
		} else
		{
			switch (action) {
			case "+":
				result = first_var + second_var;;
				break;
			case "-":
				result = first_var - second_var;
				break;
			case "*":
				result = first_var * second_var;
				break;
			case "/":
				result = first_var / second_var;
					break;
			default:
				System.out.println("Wrong input");
				return;
			}
			display(first_var, second_var, action, result);
		}
	}
}
