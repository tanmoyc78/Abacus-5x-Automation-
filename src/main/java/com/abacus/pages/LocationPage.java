package com.abacus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LocationPage extends BaseClass
{

	public String ExpectedLocationPageTitle = "Abacus - Locations" ;
	
	@FindBy(xpath = "//li//button")
	
	public WebElement Create ;
	

	
	public LocationPage(WebDriver driver)
	{
		super(driver);
		
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyLocationPageTitle()
	{
		String ActualLocationPageTitle = driver.getTitle();
		
		if(ActualLocationPageTitle.equals(ExpectedLocationPageTitle))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void clickOnCreate()
	{
		
		Create.click();
		
	}
}
