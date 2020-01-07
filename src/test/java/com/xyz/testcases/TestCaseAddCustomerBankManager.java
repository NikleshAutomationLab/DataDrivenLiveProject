package com.xyz.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.xyz.base.TestCaseBase;
import com.xyz.subscripts.BankManagerAddCustomerMethod;
import com.xyz.subscripts.BankManagerHomeMethod;
import com.xyz.utility.TestUtil;
//import com.xyz.utility.DataProviderClass;
//import com.xyz.utility.TestUtil;




public class TestCaseAddCustomerBankManager extends TestCaseBase
{
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void	testCaseAddCustomerBankManager(String firstname,String lastname,String postname,String alerttext,String runmode) 
	{
		if(!runmode.equalsIgnoreCase("Y"))
		{
			throw new SkipException("Skipping the testcase as the run mode for data set is NO");
			
		}
		
		
		log.debug("Testcase testCaseAddCustomerBankManager method execution started!!!");
		try 
		{
			
			
			
			BankManagerHomeMethod.clickonAddCustomerMenu();
			BankManagerAddCustomerMethod.fillFirstName(firstname);
			BankManagerAddCustomerMethod.fillLastName(lastname);
			BankManagerAddCustomerMethod.fillPostCode(postname);
			BankManagerAddCustomerMethod.clickAddCustomer();
			
			Thread.sleep(3000);
			
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String alertAddCustomer=alert.getText();
			Assert.assertTrue(alertAddCustomer.contains(alerttext));
			
			alert.accept();
		} 
		
		catch (Exception e) 
		{		
			e.printStackTrace();
		}
		
		log.debug("Testcase testCaseAddCustomerBankManager method execution finished!!!");
		
		
	}
	
	
	
}
