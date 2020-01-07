package com.xyz.pageobjects;


import org.openqa.selenium.By;

public interface ORBankManagerHomePage
{  

	By addCustomerBankManagerHome_CSS=By.cssSelector("button[ng-click='addCust()']");
	By openAccountBankManagerHome_CSS=By.cssSelector("button[ng-click='openAccount()']");
	By searchCustomerBankManager_CSS =By.cssSelector("button[ng-click='showCust()']");
}
