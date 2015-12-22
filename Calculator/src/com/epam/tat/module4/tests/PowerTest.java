package com.epam.tat.module4.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PowerTest extends BaseCalcTest {
	
	@Test(dataProvider = "powDp")
	public void powOneValueAnother (double a, double b, double expected) {
		double result = calc.pow(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "sqrtDp")
	public void sqrtValue (double a, double expected) {
		double result = calc.sqrt(a);
		assertEquals(result, expected, "Invalid result");
	}
	
	@DataProvider(name = "powDp")
	public Object[][] valuesForMult() {
		return new Object[][] {
			{-1.5, 2, 2.25},
			{2, 0, 1},
			{-2, -3, -0.125}
		};
	}
	
	@DataProvider(name = "sqrtDp")
	public Object[][] valuesForSqrt() {
		return new Object[][] {
			{8.41, 2.9},
			{-100, 10},
			{0, 0}
		};
	}
}