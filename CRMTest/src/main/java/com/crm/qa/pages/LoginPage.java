package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	// page factory - object repository creation 
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	//@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	@FindBy(xpath="//div[@role='navigation']/div/a[@href='https://www.freecrm.com/register/']/button[@type='button']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	// constructor 
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	// Actions 
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		// give some time for the login page to display before clicking login btn
		try {
	        Thread.sleep((int) (3000));
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		loginbtn.click();
		return new HomePage();
	}
}
