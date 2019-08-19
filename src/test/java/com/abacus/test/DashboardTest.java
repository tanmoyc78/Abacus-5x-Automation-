package com.abacus.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.abacus.pages.DashBoard;

public class DashboardTest  extends BaseTest
{
	DashBoard dashboard ;

	@Test(priority = 0 , enabled = true)
	public void dashboardTitleVerification()
	{
		dashboard = new DashBoard(driver);
		
		Assert.assertTrue(dashboard.titileValidation(), "Title is Mismatch for dashboard");
	}
}
