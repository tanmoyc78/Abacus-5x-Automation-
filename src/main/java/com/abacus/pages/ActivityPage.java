package com.abacus.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityPage extends BaseClass
{
	String PrevoiusNotesValue;
	
	
	BaseClass baseclass;

    @FindBy(xpath = "//*[@id=\"e2f98fa4-40fc-4dcb-9fcb-45752e7130bf\"]/td[1]")
	
	WebElement secondRowClick;
    
    @FindBy(xpath = "//*[@id=\"e2f98fa4-40fc-4dcb-9fcb-45752e7130bf\"]/td[21]")
	
	WebElement Notes;
    
    @FindBy(xpath = "//button[contains(@data-original-title,\"Edit activities\")]")
	
   	WebElement EditActivites;
    
    @FindBy(xpath = "//*[@id=\"ctrl_binfo_Chk_ctrl_binfo_Notes\"]")
	
   	WebElement EditNotesCheckBox;
    
    @FindBy(xpath = "//form[@class=\"form-horizontal\"]")
	
   	WebElement Form;
        
    @FindBy(xpath = "//input[contains(@class,\"form-control ui-autocomplete-input\")]")
	
   	WebElement notesInputBox;
    
    @FindBy(xpath = "//li")
	
   	List<WebElement> ListNotes;
      
    @FindBy(xpath ="//li[text()=\"Note3\"]")
    
    WebElement Notes3;
    
	public ActivityPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Bikram
	 * @throws Exception
	 * 
	 * Wait for element secondRowClick and clcik
	 */
	public void clickOn2ndRow() throws Exception
	{
		baseclass.waitAndClickOnElement(20, secondRowClick);
		
				
	}
	
	public String toGetTheNotesValue()
	{
		baseclass.waitElementToBeClickable(30, Notes);
		
		PrevoiusNotesValue = Notes.getText();

		return PrevoiusNotesValue ;
	}
	
	public void clickOnEditActivities()
	{
		EditActivites.click();
	}
	
	
	
	public void clickOnEditNotes() throws Exception
	{
		baseclass.waitAndClickOnElement(30, EditNotesCheckBox);
				
	}
	
	public void clickOnNotesInputBox()
	{
		notesInputBox.click();
		
		/*
		 * String Notes = "Note3";
		 * 
		 * int size = ListNotes.size();
		 * 
		 * for(int i = 0 ; i<size ; i++) { WebElement NotesElement = ListNotes.get(i);
		 * 
		 * String NotesName = NotesElement.getAttribute("innerHTML");
		 * 
		 * if(NotesName.equals(Notes)) { NotesElement.click(); break; }
		 * 
		 * }
		 * 
		 */
		
		baseclass.waitAndClickOnElement(30, Notes3 );
		
		
	}
	
	
}
