package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPages extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	// Initializing the Page Objects
	public ContactPages() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

}
