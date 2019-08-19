package com.abacus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends BaseClass
{

	BaseClass baseclass;
	
	public String ExpectedTitle = "Abacus - Login";
	
	@FindBy(xpath = "//a[@onclick=\"RedirectHeaderMenu('/Abacus.Manager.Web/AM/Users');\"]")
	
	public WebElement Setting ;
	
	@FindBy(xpath = "//a[@onclick=\"RedirectHeaderMenu('/Abacus.Manager.Web/TR/Activities');\"]")
	
	 WebElement Activities;
	
	
	public DashBoard(WebDriver driver)
	{
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Done by Bikram 
	 * 
	 * It will verify the dashboard title 
	 * @return
	 */
	public boolean titileValidation()
	{
		String ActualTitle = driver.getTitle();
		
		if(ActualTitle.equals(ExpectedTitle))
		{
			return true ;
			
		}
		else 
		{
			return false ;
		}
	}

	/**
	 * Done By Bikram 
	 * 
	 * It will click on Setting
	 */
	public void clickOnSetting()
	{
	
//		baseclass = new BaseClass(driver);
		
		baseclass.waitElementToBeClickable( 40, Setting );
		 
		 Setting.click();
		
	}
	
	public void cliclOnActivities()
	{
		baseclass = new BaseClass(driver);
		baseclass.waitElementToBeClickable(20, Activities);
		
		Activities.click();
	}
	
}
