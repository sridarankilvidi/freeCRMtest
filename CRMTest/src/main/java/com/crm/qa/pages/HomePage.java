package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: sridaran kilvidi')]")
	@CacheLookup //this annotation will speed up execution of 
	//finding this particular element from cache. include this before 
	//other annotations for speeding up test execution
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	// constructor 
	public HomePage(){
		PageFactory.initElements(driver,this);
		}
	
	// Actions 
	public String validateHomePageTitle(){
		return driver.getTitle();
		}
	
	public boolean validateCorrectUerName(){
		return userNameLabel.isDisplayed();
		}
	
	public contactsPage clickOnContactsLink(){
		contactsLink.click();
		return new contactsPage();	
		}
	// hover the mouse over contact main menu and
	//click on the newcontact submenu
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
}// test base
