package com.xyz.pageobjects;

import org.openqa.selenium.By;

public interface ORBankManagerAddCustomerPage 
{
	By firstNameAddCustomerBankManager = By.cssSelector("input[ng-model='fName']");
	By lastNameAddCustomerBankManager = By.cssSelector("input[ng-model='lName']");
	By postCodeAddCustomerBankManager = By.cssSelector("input[ng-model='postCd']");
	By btnAddCustomerBankManager = By.cssSelector("button[type='submit']");

}
