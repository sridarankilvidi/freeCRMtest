package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	//constructor
	public LoginPageTest(){
		super();
		System.out.println("TestBase Class-properties file is loaded successfully!");
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		System.out.println("TestBase Class - initialization() function completed successfully!");
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String actualtitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(actualtitle,"#1 Free CRM for Any Business: Online Customer Relationship Software" );
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest(){
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
