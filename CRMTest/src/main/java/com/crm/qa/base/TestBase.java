package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
//constructor
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//public static String chromePath="C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
	public static String chromePath="C:/Ecipse/selenium Luna/chromedriver_win32/chromedriver.exe";
	
	public TestBase(){
		try{
			prop=new Properties();
			
			//C:\Users\srida\.jenkins\workspace\freeCRMtest_github\CRMTest\src\main\java\com\crm\qa\config
			//FileInputStream ip= new FileInputStream("C:/Ecipse/selenium Luna/Projects/CRMTest/src/main/java/com/crm/qa/config/config.properties");	
			//FileInputStream ip= new FileInputStream("C:/Users/srida/git/freeCRMtest/CRMTest/src/main/java/com/crm/qa/config/config.properties");
			FileInputStream ip= new FileInputStream("C:/Users/srida/.jenkins/workspace/freeCRMtest_github/CRMTest/src/main/java/com/crm/qa/config");
			prop.load(ip);	
			}catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException");
				e.printStackTrace();
			}catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
			}//try
			
	}// test base constructor

	public static void initialization(){
		//String browserName = prop.getProperty("browser");
		String browserName = "chrome";
		if(browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Ecipse/GeckoDriver for firefox-new/geckodriver-v0.19.0-win64/geckodriver");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}// initialization

}// test base class
