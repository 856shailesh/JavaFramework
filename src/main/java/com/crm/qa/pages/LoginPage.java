package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory - Object Repository

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement login;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//image[@src='/images/cogtiny1.jpg']")
	WebElement crmLogo;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}

	public boolean validateCRMlogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String mail, String pwd) {
		login.click();
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}

}
