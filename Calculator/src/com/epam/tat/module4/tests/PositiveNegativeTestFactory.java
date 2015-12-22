package com.epam.tat.module4.tests;

import org.testng.annotations.Factory;

public class PositiveNegativeTestFactory {
	
	@Factory
	public Object [] getTests() {
		return new Object[] {
			new PositiveNegativeTest(10, true, false),
			new PositiveNegativeTest(0, false, false),
			new PositiveNegativeTest(-1, false, true)
		};
	}
}
