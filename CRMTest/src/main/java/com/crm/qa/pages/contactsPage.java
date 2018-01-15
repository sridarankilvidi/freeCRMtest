package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class contactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	// constructor 
	public contactsPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public boolean validateContactsByName(String name){
		//driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).isDisplayed();
		String newContact = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).getText();
		//System.out.println(newContact);
		return newContact.equals(name);
	}
	
	public void createNewContact(String title, String fname,String lname, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
