package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase


{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	String sheetName = "Sheet1";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil=new TestUtil();
		loginPage=new LoginPage();
		contactsPage=new ContactsPage();
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		contactsPage.selectContactsByName("gg mm");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName("ff hh");
		contactsPage.selectContactsByName("David Cris");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider ="getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Dr.", "jhon", "Peter", "infosys");
		contactsPage.createNewContact(title, firstname, lastname, company);
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
