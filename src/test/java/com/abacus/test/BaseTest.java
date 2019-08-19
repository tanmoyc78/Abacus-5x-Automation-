package com.abacus.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.abacus.pages.LoginPage;
import com.abacus.utils.AutoConstant;

public class BaseTest implements AutoConstant {

	public static WebDriver driver;

	LoginPage loginpage;

	@BeforeMethod
	public void configuratio() throws InterruptedException {
		System.setProperty(GECKO_KEY, GECKO_VALUE);

		/*
		 * driver = new ChromeDriver();
		 */
		
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().deleteAllCookies();
		loginpage = new LoginPage(driver);
		loginpage.loginWithValidCredentials();
		Thread.sleep(5000);
		loginpage.loginWithValidCredentials();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void windowClose()
	{
		 //driver.quit();
	}
}
