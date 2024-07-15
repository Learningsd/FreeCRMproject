package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase 
{
	
	@FindBy(xpath="//td[contains(text(),'User: Gagan Khanna')]")
	@CacheLookup
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactslink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	@CacheLookup
	WebElement Newcontactslink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	@CacheLookup
	WebElement Dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement tasklink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName()
	{
		return userNamelabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		Dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasklink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		Newcontactslink.click();
		
	}
	
	

}
