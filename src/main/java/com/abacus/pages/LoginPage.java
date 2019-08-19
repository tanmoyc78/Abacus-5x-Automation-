package com.abacus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass
{

	@FindBy(xpath ="//input[contains(@data-bind,'LoginOptions.Username')]")
	
	public WebElement UserNameOptionbutton;
	
	@FindBy(id ="txtUserName")
	
	public WebElement UserNameInputBox;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	
	public WebElement PasswordInputBox;
	
	@FindBy(xpath = "//button[text()='Login']")
	
	public WebElement LoginButton;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	/**
	 * Bikram
	 */
	public void clickonUserNameOptionbutton()
	{
		UserNameOptionbutton.click();
	}
	
	/**
	 * Bikram
	 */
	public void enterUsername()
	{
		UserNameInputBox.sendKeys("admin");
	}
	
	/**
	 * Bikram
	 */
	public void enterPassword()
	{
		PasswordInputBox.sendKeys("arcind");
	}

	/**
	 * Bikram
	 */
	public void clikOnLoginButton()
	{
	
		LoginButton.click();
	}
	
	public void loginWithValidCredentials() {
		clickonUserNameOptionbutton();
		enterUsername();
		enterPassword();
		clikOnLoginButton();
	}
	
}
