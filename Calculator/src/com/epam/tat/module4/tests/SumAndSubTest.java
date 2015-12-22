package com.epam.tat.module4.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumAndSubTest extends BaseCalcTest {
	
	@Test(dataProvider = "sumDpLong")
	public void oneValuePlusAnotherLong(long a, long b, long expected) {
		long result = calc.sum(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "sumDpDouble")
	public void oneValuePlusAnotherDouble(double a, double b, double expected) {
		double result = calc.sum(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "subDpLong")
	public void oneValueMinusAnotherLong(long a, long b, long expected) {
		long result = calc.sub(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "subDpDouble")
	public void oneValueMinusAnotherDouble(double a, double b, double expected) {
		double result = calc.sub(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@DataProvider(name = "sumDpLong")
	public Object[][] valuesForSumLong() {
		return new Object[][] {
			{20, 15, 35},
			{1,-10,-9},
			{0,0,0}
		};
	}
	
	@DataProvider(name = "sumDpDouble")
	public Object[][] valuesForSumDouble() {
		return new Object[][] {
			{1, 2.5, 3.5},
			{0,0,0}
		};
	}
	
	@DataProvider(name = "subDpLong")
	public Object[][] valuesForSubLong() {
		return new Object[][] {
			{9, 6, 3},
			{1,-10,11},
			{0,0,0}
		};
	}
	
	@DataProvider(name = "subDpDouble")
	public Object[][] valuesForSubDouble() {
		return new Object[][] {
			{1.23, 0.24, 0.99},
			{0,0,0}
		};
	}
	

}
