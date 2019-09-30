package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPages extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//i[@class='edit icon']")
	WebElement newContactsBtn;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "first_name")
	WebElement lastName;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects
	public ContactPages() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContactByName(String fname, String lName) {
		newContactsBtn.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		saveBtn.click();
	}

}
