package com.abacus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{

	public static WebDriver driver ;
	
	public BaseClass(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	public static void waitElementToBeClickable(int Time , WebElement element)
	{
		 WebDriverWait d = new WebDriverWait(driver, Time);
			
		 d.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public static void waitAndClickOnElement(int Time , WebElement element)
	{
		WebDriverWait d = new WebDriverWait(driver, Time);
		
		 d.until(ExpectedConditions.elementToBeClickable(element) );
		 
		 element.click();
	}
	
	public static void switchToEditActivityFrame(WebElement FrameElement)
	{
		driver.switchTo().frame(FrameElement);
	}
}
