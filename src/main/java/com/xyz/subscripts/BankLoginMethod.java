package com.xyz.subscripts;

import org.openqa.selenium.WebElement;

import com.xyz.base.TestCaseBase;


public class BankLoginMethod extends TestCaseBase
{

	public static void clickBankManagerLoginBtn()
	{
	  WebElement elBankManagerLoginBtn = driver.findElement(BankManagerBtnLogin_CSS);
	  highlightElement(elBankManagerLoginBtn);
	  elBankManagerLoginBtn.click();	
	}

}
