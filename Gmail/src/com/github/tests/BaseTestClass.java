package com.github.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
	
	final String startUrl = "http://google.com";
	final String login = "TestSeleniumProject";
	final String password = "selenium";
	
	final String address = "san4e3z2010@yandex.ru";
	final String subject = "object of message";
	final String body = "text in the body";
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
