package com.xyz.subscripts;

import org.openqa.selenium.WebElement;

import com.xyz.base.TestCaseBase;



public class BankManagerAddCustomerMethod extends TestCaseBase
{
	public static void fillFirstName(String firstName)
	{
		
		WebElement weFirstNameAddCustBankMang = driver.findElement(firstNameAddCustomerBankManager);
		highlightElement(weFirstNameAddCustBankMang);
		weFirstNameAddCustBankMang.sendKeys(firstName);
	}
	
	public static void fillLastName(String lastName)
	{
		WebElement weLastNameAddCustBankMang = driver.findElement(lastNameAddCustomerBankManager);
		highlightElement(weLastNameAddCustBankMang);
		weLastNameAddCustBankMang.sendKeys(lastName);
	}
	
	public static void fillPostCode(String postCode)
	{
		WebElement wePostCodeAddCustBankMang = driver.findElement(postCodeAddCustomerBankManager);
		highlightElement(wePostCodeAddCustBankMang);
		wePostCodeAddCustBankMang.sendKeys(postCode);
	}
	
	public static void clickAddCustomer()
	{
		WebElement weaddCustBtn = driver.findElement(btnAddCustomerBankManager);
		highlightElement(weaddCustBtn);
		weaddCustBtn.click();
	}
	
}
