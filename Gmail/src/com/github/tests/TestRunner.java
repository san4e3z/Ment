package com.github.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;;

public class TestRunner {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		String startUrl = "http://google.com";
		String login = "TestSeleniumProject";
		String password = "selenium";
		
		String address = "san4e3z2010@yandex.ru";
		String subject = "object of message";
		String body = "text in the body";		
		
		//login in gmail
		driver.get(startUrl);
		driver.findElement(By.linkText("Войти")).click();		
		driver.findElement(By.id("Email")).sendKeys(login);		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
		driver.findElement(By.id("next")).click();		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("Passwd")).sendKeys(password);		
		driver.findElement(By.id("signIn")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//navigate to mail page
		driver.findElement(By.linkText("Почта")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
		
		//Create a new mail 
		driver.findElement(By.xpath("//div[contains(text(),'НАПИСАТЬ')]")).click();
		driver.findElement(By.xpath("//textarea")).sendKeys(address);
		driver.findElement(By.name("subjectbox")).sendKeys(subject);
		WebElement inputMesField = driver.findElement(By.xpath("//div[@aria-label='Тело письма']"));
		inputMesField.click();
		inputMesField.sendKeys(body);
		//Save the mail as a draft
		driver.findElement(By.xpath("//img [@aria-label='Сохранить и закрыть']")).click();
		
		//Verify, that the mail presents in Drafts
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Черновики")).click();
		boolean checkSubject1 = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkMessage1 = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		System.out.println(checkSubject1 + " " + checkMessage1);
		List<WebElement> listOfDrafts = driver.findElements(By.xpath("//span[contains (text(),'" + subject + "')]"));
		listOfDrafts.get(0).click();
		
		
		boolean checkSubject = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkEmail = driver.findElement(By.xpath("//div/*[contains(text(),'" +  address + "')]")).isEnabled();
		boolean checkMessage = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		System.out.println(checkSubject + " " + checkEmail + " " + checkMessage);
		
		
		//SEND
		driver.findElement(By.xpath("//div[contains(text(),'Отправить')]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//Verify, that the mail disappeared from Drafts
		
		
		
		//Verify, that the mail is in Sent
		driver.findElement(By.linkText("Отправленные")).click();
		boolean checkSubject2 = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkMessage2 = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		System.out.println(checkSubject2 + " " + checkMessage2);
		
		
		//log off
		driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Выйти")).click();
		
		driver.switchTo().alert().accept();
		
		//driver.close();
		
		

		
		
		
	}

}
