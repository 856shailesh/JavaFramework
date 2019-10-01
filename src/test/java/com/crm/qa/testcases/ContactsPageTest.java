package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPages;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPages contactsPage;
	
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		contactsPage = new ContactPages();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password")); //prop is coming by using the super , it will call the constructor of base class		
		contactsPage = homePage.clickOnConatactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contatct Label Missing");
	}
	
	@DataProvider
	public Object[][] getCRMtestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test (priority=2 , dataProvider = "getCRMtestData")
	public void validateCreateNewContact(String fname, String lname) {
		homePage.clickOnConatactsLink();
		//contactsPage.createNewContactByName("Mohandas", "Gandhi");
		contactsPage.createNewContactByName(fname, lname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}
