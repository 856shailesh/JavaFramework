package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='Shailesh Sharma']")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement tasksLink;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactPages clickOnConatactsLink() {
		contactsLink.click();
		return new ContactPages();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOntasksLink() {
		tasksLink.click();
		return new TaskPage();
	}

}
