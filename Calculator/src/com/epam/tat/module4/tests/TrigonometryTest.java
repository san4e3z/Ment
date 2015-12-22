package com.epam.tat.module4.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;


public class TrigonometryTest extends BaseCalcTest {
	
	@Test(priority = 1)
	public void sinFromValue() {
		double result = round(calc.sin(Math.toRadians(30)));
		assertEquals(result, 0.5);
	}
	
	@Test(priority = 2)
	public void cosFromValue() {
		double result = round(calc.cos(Math.toRadians(30+180)));
		assertEquals(result, -0.8660);
	}
	
	@Test(priority = 3)
	public void tgFromValue() {
		double result = round(calc.tg(Math.PI/3));
		assertEquals(result, 1.7321);
	}
	
	@Test(priority = 4)
	public void arctgFromValue() {
		double result = round(calc.ctg(1));
		assertEquals(result, 0,7616);
	}
	
	@Test(expectedExceptions = NumberFormatException.class, priority = 0)
	public void checkDivisionByZeroThrowsException(){
		double result = calc.tg(Math.PI/2);
	}
	
	private double round (double value) {
		return (double) Math.round(value * 10000d) / 10000d;
	}

}


