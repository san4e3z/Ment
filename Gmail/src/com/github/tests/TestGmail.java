package com.github.tests;

import static org.testng.AssertJUnit.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestGmail extends BaseTestClass {
	
	@Test(priority = 0)
	public void logIn() {
		driver.get(startUrl);
		driver.findElement(By.linkText("Войти")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='Email']")));
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(login);
		driver.findElement(By.id("next")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Passwd")));
		driver.findElement(By.cssSelector("input#Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Почта")));
		driver.findElement(By.linkText("Почта")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'НАПИСАТЬ')]")));
		List<WebElement> checkButtons = driver.findElements(By.xpath("//div[contains(text(),'НАПИСАТЬ')]"));
		assertTrue(!checkButtons.isEmpty());
	}
	
	@Test(priority = 1)
	public void createDraft() {
		driver.findElement(By.xpath("//div[contains(text(),'НАПИСАТЬ')]")).click();
		driver.findElement(By.xpath("//textarea[@aria-label='Кому']")).sendKeys(address);
		driver.findElement(By.name("subjectbox")).sendKeys(subject);
		WebElement inputMessageField = driver.findElement(By.xpath("//div[@aria-label='Тело письма']"));
		inputMessageField.click();
		inputMessageField.sendKeys(body);
		driver.findElement(By.xpath("//img [@aria-label='Сохранить и закрыть']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		assertTrue(!driver.findElement(By.xpath("//div[contains(text(),'Отправить')]")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void checkDraftMessage() {
		driver.findElement(By.partialLinkText("Черновики")).click();
		boolean checkSubject = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkMessage = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		assertTrue(checkSubject && checkMessage);
	}
	
	@Test(priority = 3)
	public void checkDraftContentMessage() {
		List<WebElement> listOfDrafts = driver.findElements(By.xpath("//span[contains (text(),'" + subject + "')]"));
		listOfDrafts.get(0).click();
		boolean checkSubject = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkEmail = driver.findElement(By.xpath("//div/*[contains(text(),'" +  address + "')]")).isEnabled();
		boolean checkMessage = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		assertTrue(checkSubject && checkEmail && checkMessage);
	}
	
	@Test(priority = 4)
	public void sendMail() {
		driver.findElement(By.xpath("//div[contains(text(),'Отправить')]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Письмо отправлено.')]")).isEnabled());	
	}
	
	@Test(priority = 5)
	public void checkDraftList() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Черновики")).click();
		assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Нет сохраненных черновиков.')]")).isEnabled());
	}
	
	@Test(priority = 6)
	public void checkSendList() {
		driver.findElement(By.linkText("Отправленные")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean checkSubject = driver.findElement(By.xpath("//div/*[contains(text(),'" +  subject + "')]")).isEnabled();
		boolean checkMessage = driver.findElement(By.xpath("//div/*[contains(text(),'" +  body + "')]")).isEnabled();
		assertTrue(checkSubject && checkMessage);
	}
	
	@Test(priority = 7)
	public void logOff() {
		driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")).click();
		//driver.findElement(By.cssSelector("a[title='Аккаунт Google: Alex Parfenov (testseleniumproject@gmail.com)']"));
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Выйти")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//driver.switchTo().alert().accept();
		assertTrue(driver.findElement(By.id("account-chooser-link")).isDisplayed());
	}

}
