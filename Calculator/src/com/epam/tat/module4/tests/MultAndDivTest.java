package com.epam.tat.module4.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultAndDivTest extends BaseCalcTest {
	
	@Test(dataProvider = "divDpLong", groups = "div")
	public void divOneValueAnotherLong (long a, long b, long expected) {
		long result = calc.div(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "divDpDouble", groups = "div")
	public void divOneValueAnotherDouble (double a, double b, double expected) {
		double result = calc.div(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "multDpLong", groups = "mult")
	public void multOneValueAnotherLong (long a, long b, long expected) {
		long result = calc.mult(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(dataProvider = "multDpDouble", groups = "mult")
	public void multOneValueAnotherDouble (double a, double b, double expected) {
		double result = calc.mult(a, b);
		assertEquals(result, expected, "Invalid result");
	}
	
	@Test(expectedExceptions = NumberFormatException.class, groups = "div", expectedExceptionsMessageRegExp = ".*zero.*")
	public void checkDivisionByZeroThrowsException(){
		long result = calc.div(10, 0);
	}
	
	@DataProvider(name = "divDpLong")
	public Object[][] valuesForDivLong() {
		return new Object[][] {
			{20, 2, 10},
			{1,-2, 0},
			{3, 2, 1}
		};
	}
	
	@DataProvider(name = "divDpDouble")
	public Object[][] valuesForDivDouble() {
		return new Object[][] {
			{2, -3, -0.6666666666666666},
			{1, 2, 0.5}
		};
	}
	
	@DataProvider(name = "multDpLong")
	public Object[][] valuesForMultLong() {
		return new Object[][] {
			{20, 2, 40},
			{1,-2, -2},
			{0, 2, 0}
		};
	}
	
	@DataProvider(name = "multDpDouble")
	public Object[][] valuesForMultDouble() {
		return new Object[][] {
			{1.34, 1/0.67, 2},
			{2.0, 3.1, 6.2}
		};

	}
}

