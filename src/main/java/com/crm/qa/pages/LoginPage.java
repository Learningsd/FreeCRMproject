package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase
{
	//pagefactory @findby annotation
	
	@FindBy(name ="username")
	WebElement username;

	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement Crmlogo;
	
	//CONSTRUCTOR
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS
	public String ValidateloginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCRMlogo()
	{
		return Crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
}
