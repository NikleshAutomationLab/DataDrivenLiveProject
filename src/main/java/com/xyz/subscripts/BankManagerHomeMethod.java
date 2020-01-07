package com.xyz.subscripts;

import org.openqa.selenium.WebElement;

import com.xyz.base.TestCaseBase;
;


public class BankManagerHomeMethod extends TestCaseBase
{
	
	public static void clickonAddCustomerMenu()
	{
		WebElement weAddCutomerBankManagerHome = driver.findElement(addCustomerBankManagerHome_CSS);
		highlightElement(weAddCutomerBankManagerHome);
		weAddCutomerBankManagerHome.click();	
	}

}
