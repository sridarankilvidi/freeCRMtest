package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.contactsPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	contactsPage contactspage;
	TestUtil testutil;
	
	//constructor
		public ContactsPageTest(){
			super();
			//System.out.println("TestBase Class-properties file is loaded successfully!");
		}
		
		@BeforeMethod
		public void setUp(){
			initialization();
			//System.out.println("TestBase Class - initialization() function completed successfully!");
			loginpage = new LoginPage();
			homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
			testutil=new TestUtil();
			testutil.switchToFrame();
			contactspage = homepage.clickOnContactsLink();		
		}
		@Test(priority=1)
		public void verifycontactsLabel(){
			//testutil.switchToFrame();
			Assert.assertTrue(contactspage.validateContactsLabel());
		}
		
		@Test(priority=2)
		public void selectContactsTest(){
			contactspage.selectContactsByName("vasanth sridaran");
		}
		
		@DataProvider
		public Object[][] getCRMTestData(){
			Object[][] data = TestUtil.getTestData();
			return data;
		}
		
		@Test(priority=3, dataProvider="getCRMTestData")
		public void createNewContactTest(String title, String fname,String lname, String comp){
			homepage.clickOnNewContactLink();
			contactspage.createNewContact(title, fname, lname, comp);
			//driver.navigate().refresh();
			Assert.assertTrue(contactspage.validateContactsByName(fname+" "+lname));
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}

}
