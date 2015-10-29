package com.github.list.java;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
	
	private static void display(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			String str = array.get(i);
			System.out.println(str);
		}
	}
	
	private static void reverse(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			String tmp = "";
			String str = array.get(i);
			for (int j = str.length() - 1; j >= 0; j--) {
				tmp += str.charAt(j);
			}
			array.set(i, tmp);
		}	
	}
	
	private static void reverseStringBuilder(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			StringBuilder str= new StringBuilder(array.get(i));
			array.set(i, str.reverse().toString());
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arrList = new ArrayList<String>();
		
		System.out.println("Fill string list (input 'exit' to complete the application)");
		
        while (!sc.hasNext("exit")) {
            arrList.add(sc.nextLine());
        } 
        sc.close();
        
        reverse (arrList);
        
        //reverseStringBuilder(arrList);
        
        System.out.println("String list after reversing:");
        display(arrList);

	}
}
