package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Alert message has been accepted");
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Alert message has been dismissed");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Element Value changed to:" +element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Element that was clicked on:" +element.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Found Element By: " +by.toString());
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated Back to Previous Page");
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated Forward to the Next Page");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Page has been Refreshed");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Navigated to : '"+url+"'");
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to accept Alert Message");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Dismiss the Alert Message");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Value of Element:" +element.toString() +"Before any changes are made");
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to find Element By: " +by.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Navigating back to Previous Page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Navigating to the Next Page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Trying to Refresh the Page");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Before Navigating to : '"+url+"'");
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Exception Occured :" + error);
		try{
			TestUtil.takeScreenshotAtEndOfTest();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1,
			CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

}
