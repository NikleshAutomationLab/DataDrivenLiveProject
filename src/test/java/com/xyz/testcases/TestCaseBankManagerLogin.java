package com.xyz.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.xyz.base.TestCaseBase;
import com.xyz.subscripts.BankLoginMethod;
import com.xyz.utility.TestUtil;


public class TestCaseBankManagerLogin extends TestCaseBase
{
	

	
	@Test
	public void TestCaseBankManagerLogin() throws IOException
	{
		log.debug("Testcase TestCaseBankManagerLogin method execution started!!!");
	
		try 
		{
			
			BankLoginMethod.clickBankManagerLoginBtn();
			Thread.sleep(3000);
			
			Assert.assertTrue(driver.findElement(addCustomerBankManagerHome_CSS).isDisplayed(), "Login is Successful and able to see add Customer button");
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		log.debug("Testcase TestCaseBankManagerLogin method execution finished!!!");
		
	}
	
	
	
	


}
