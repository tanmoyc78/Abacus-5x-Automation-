package com.abacus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.abacus.pages.DashBoard;
import com.abacus.pages.LocationPage;
import com.abacus.pages.SettingPage;

public class LocationTest extends BaseTest
{
	DashBoard dashboard;
	
	SettingPage settingpage;
	
	LocationPage locationpage;

	/**
	 * Done By Bikram 
	 * 
	 * To navigate to location page 
	 * @throws Exception 
	 */
	@Test(priority = 0 , enabled = true , description = "Navigate to Loaction and validate location page title")
	public void navigateToLocation() throws Exception
	{
		dashboard =  new DashBoard(driver);
		
		//This will clik on Setting
		dashboard.clickOnSetting();
		
		settingpage = new SettingPage(driver);
		
		//This will scroll down to location 
		
		settingpage.clickOnLocation();
			
	}
	
	/**
	 * Done By Bikram 
	 * 
	 * This will click on Create Button
	 * @throws Exception
	 */
	@Test(priority = 1, enabled = true , description = "Location page click on Create button")
	public void clickOnCreate() throws Exception
	{
      dashboard =  new DashBoard(driver);
		
		//This will clik on Setting
		dashboard.clickOnSetting();
		
		settingpage = new SettingPage(driver);
		
		//This will scroll down to location 
		
		settingpage.clickOnLocation();
		
         locationpage = new LocationPage(driver);
		
		Assert.assertTrue(locationpage.verifyLocationPageTitle(), "Page title did't match");
		
		locationpage.clickOnCreate();
	}
}
