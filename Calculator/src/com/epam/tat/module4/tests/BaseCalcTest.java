package com.epam.tat.module4.tests;


import com.epam.tat.module4.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Date;

public class BaseCalcTest {
	
	protected Calculator calc;
	
	@BeforeSuite
	public void setUpBeforeSuite() {
		System.out.println("Start suite");
	}
	
	@BeforeClass
	public void setUp(){
		calc = new Calculator();
	}
	
	@BeforeClass(groups = "div")
	public void setUp1(){
		calc = new Calculator();
	}
	
	@BeforeClass(groups = "mult")
	public void setUp2(){
		calc = new Calculator();
	}
	
	@BeforeTest
	protected void checkTime() {
		System.out.println("Current time is " + new Date(System.currentTimeMillis()));
	}
	
	@AfterSuite
	public void endSuite() {
		System.out.println("End suite");
	}

}
