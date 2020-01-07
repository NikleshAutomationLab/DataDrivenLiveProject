package com.xyz.utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.xyz.base.TestCaseBase;

public class TestUtil extends TestCaseBase {

	
	public static String capScreenshot(String screenName) throws IOException
	{
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd MM YYYY hh mm ss");
		 String currentDate = sdf.format(date);
		 
		 TakesScreenshot Screenshot = (TakesScreenshot)driver;
		 File srcScreenshot = Screenshot.getScreenshotAs(OutputType.FILE);
		
		 
		 String destiScreenshot = System.getProperty("user.dir")+"\\TestcaseScreenshot"+"\\"+screenName+"\\"+currentDate+".png";
		 File destifile = new File(destiScreenshot);
		 FileUtils.copyFile(srcScreenshot, destifile);
		 
				 
		return destiScreenshot;
	
	
	}
	
	/*
	@DataProvider(name="dp")
	public Object[][] getData(Method m) 
	{

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}*/

	

	@DataProvider(name="dp")
	public Object[][] getData(Method m) 
	{

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];
		
		//Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			//table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				//table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}

		}

		return data;

	}
		
}
