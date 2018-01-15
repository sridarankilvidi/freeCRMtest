package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String FreeCRM_TestData_Path="C:/Ecipse/selenium Luna/Projects/CRMTest/src/main/java/com/crm/qa/testdata/FreeCRMData.xlsx";
	
	public void switchToFrame(){
		//user name is displayed in a different frame
		//use view source to know the frame name
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(){
		FileInputStream file = null;
		Workbook book = null;
		Sheet sheet;
		
		try{
			file = new FileInputStream(FreeCRM_TestData_Path);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}//try
		
		try{
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet("Sheet1");
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0; i<sheet.getLastRowNum(); i++ ){
			for (int k=0; k<sheet.getRow(0).getLastCellNum() ; k++){
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}//get test data
	
	public static void takeScreenshotAtEndOfTest()throws IOException{
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		Date date= new Date();
		String currentDir = "C:/Ecipse/selenium Luna/Projects/CRMTest/Screenshots/";
		//File snapshotFile = new File(currentDir+date+".png");	
		File snapshotFile = new File(currentDir+System.currentTimeMillis()+".png");
		FileHandler.copy(scrFile,snapshotFile);
		//FileHandler.copy(scrFile, new File(currentDir+"/Screenshots/"+System.currentTimeMillis()+".png"));
		//FileUtils.copyFile(scrFile,new File(currentDir + "/Screenshots /"+System.currentTimeMillis()+".png"));
	}
}
