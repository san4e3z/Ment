package com.github.multmatrix.java;

import java.util.Scanner;

public class matrix {
	
	public static void displayMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void fillMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*10);
			}
		}
	}
	
	public static int[][] multiplyMatrix(int[][] A, int[][] B) {
		
	    int[][] C;
	    C = new int[A.length][B[0].length];
	    
	    for (int i = 0; i < A.length; i++) {
	    	for (int j = 0; j < B[0].length; j++) {
	    		int temp = 0;
	    		for (int k = 0; k < B.length; k++) {
	    			temp += A[i][k]*B[k][j];
	    		}
	    		C[i][j] = temp;
	    	}
	    }
	    return C;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input size of 1st matrix (format rows x columns)");
		int rowsA = sc.nextInt();
		int colsA = sc.nextInt();
		System.out.println("Please input size of 2nd matrix (only rows)");
		int colsB = sc.nextInt();
		int rowsB = colsA;
		
		int[][] matrixA, matrixB, matrixC;
		
		matrixA = new int[rowsA][colsA];
		matrixB = new int[rowsB][colsB];
		matrixC = new int[rowsA][colsB];
		
		fillMatrix(matrixA);
		fillMatrix(matrixB);
		
		System.out.println("1st matrix:");
		displayMatrix(matrixA);
		System.out.println("2nd matrix:");
		displayMatrix(matrixB);
		
		matrixC = multiplyMatrix(matrixA, matrixB);
		
		System.out.println("Result matrix:");
		displayMatrix(matrixC);
	}

}
