package com.epam.tat.module4.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PositiveNegativeTest extends BaseCalcTest {
	
	private long value;
	private boolean expectedToBePositive;
	private boolean expectedToBeNegative;
	
	//@Factory(dataProvider = "valuesDp")
	public PositiveNegativeTest(long value, boolean expectedToBePositive, boolean expectedToBeNegative) {
		this.value = value;
		this.expectedToBePositive = expectedToBePositive;
		this.expectedToBeNegative = expectedToBeNegative;
	}
	
	@Test
	public void checkValuePositive() {
		assertTrue(calc.isPositive(value) == expectedToBePositive);
	}
	
	@Test
	public void checkValueNegative() {
		assertTrue(calc.isNegative(value) == expectedToBeNegative);
	}
	
	//@DataProvider(name = "valuesDp")
	public static Object[][] valuesForCheck() {
		return new Object[][] {
				{1, true, false},
				{-1, false, true},
				{-1000, false, true},
				{0, false, false}
		};
	}

}
