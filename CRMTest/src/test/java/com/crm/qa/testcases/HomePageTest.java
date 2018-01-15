package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.contactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	contactsPage contactspage;
	HomePage homepage;
	TestUtil testutil;
	
	//constructor
	public HomePageTest(){
		super();
		System.out.println("TestBase Class-properties file is loaded successfully!");
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		System.out.println("TestBase Class - initialization() function completed successfully!");
		loginpage = new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		testutil=new TestUtil();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String actualtitle = homepage.validateHomePageTitle();
		Assert.assertEquals(actualtitle,"CRMPRO","ERROR=====Home Page Title Does not match!" );
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest(){
		testutil.switchToFrame();
		Assert.assertTrue(homepage.validateCorrectUerName());
	}
	
	@Test(priority=3)
	public void clickContactsLinkTest(){
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
