package com.xyz.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.xyz.pageobjects.ORBankLoginPage;
import com.xyz.pageobjects.ORBankManagerAddCustomerPage;
import com.xyz.pageobjects.ORBankManagerHomePage;
import com.xyz.utility.ExcelReader;
import com.xyz.utility.ExtentManager;

public class TestCaseBase implements ORBankLoginPage,ORBankManagerAddCustomerPage,ORBankManagerHomePage
{
	
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\excel\\testdata.xlsx");
	
	public  ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setup()
	{
		if(driver==  null)
		{
			
			try {
				String configfilePath = "\\Properties\\Config.properties";
				fis = new FileInputStream(System.getProperty("user.dir")+configfilePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(Config.getProperty("browser").equals("chrome"))
			{ 
				String chromedriverPath ="\\src\\main\\resources\\executableswebdriver\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+chromedriverPath);		
				driver = new ChromeDriver();
				log.debug("Launched Chrome Driver");
				
			}
			else if(Config.getProperty("browser").equals("firefox"))
			{
				String firefoxPath ="\\src\\main\\resources\\executableswebdriver\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+firefoxPath);
				driver = new FirefoxDriver();
				log.debug("Launched FireFox Driver");
			}
			
			driver.get(Config.getProperty("TestsiteURL"));
			log.debug("Navigated to: "+Config.getProperty("TestsiteURL"));
			driver.manage().window().maximize();
			log.debug("Browser is maximized");
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicitwait")),
					TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			
		}
		
		
	}
	
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		
		jsExecutor.executeScript( "arguments[0].setAttribute('style', arguments[1]);",
                element, "color: green; border: 5px solid red;");
		
	}
	
	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
		log.debug("Test Execution completed!!!");
	}
	
}
