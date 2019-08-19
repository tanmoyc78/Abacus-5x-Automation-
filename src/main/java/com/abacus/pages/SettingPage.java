package com.abacus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPage extends BaseClass
{

	@FindBy(xpath ="//a[@url=\"/Abacus.Manager.Web/AM/Locations\"]")
	public WebElement Location;
	
	
	public SettingPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLocation() throws Exception
	{
		Location.click();
		
	}
	
}
