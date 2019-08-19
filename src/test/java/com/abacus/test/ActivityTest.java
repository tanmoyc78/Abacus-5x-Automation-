package com.abacus.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.abacus.pages.ActivityPage;
import com.abacus.pages.BaseClass;
import com.abacus.pages.DashBoard;
import com.abacus.pages.LoginPage;

public class ActivityTest extends BaseTest {

	LoginPage loginpage;
	DashBoard dashboard;
	ActivityPage activitypage;

	Logger log = Logger.getLogger(ActivityTest.class);

	@Test(priority = 0, enabled = true, description = "Edit Activities")
	public void editActivity() throws Exception
	{
		dashboard = new DashBoard(driver);

		loginpage = new LoginPage(driver);

		log.info("Activity edit begain");

		dashboard.cliclOnActivities();

		log.info("Click on Activities is done  ");
		
		log.info("Click on second Row of Activity Grid");
		
		activitypage = new ActivityPage(driver);
		
		activitypage.clickOn2ndRow();
		
		log.info("Second Row Of Activity Grid is slected");

		String PreviousNotes = activitypage.toGetTheNotesValue();
		
		log.info("Current Notes Values = "+PreviousNotes);
		
		activitypage.clickOnEditActivities();
		
		log.info("Edit Activities Click is done ");
		
		activitypage.clickOnEditNotes();
		
		log.info("Clcik on edits Notes");

		activitypage.clickOnNotesInputBox();
		
		log.info("Click on Notes Input Box");
					
		log.info("Select Notes From List is done ");

	}

}
