 package com.xyz.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.xyz.base.TestCaseBase;
import com.xyz.utility.MonitoringMail;
import com.xyz.utility.TestConfig;
import com.xyz.utility.TestUtil;

public class CustomListeners extends TestCaseBase implements ITestListener,ISuiteListener
{
	public String messageBody;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		// TODO Auto-generated method stub
		
		if(result.getStatus()==result.FAILURE)
		{
			log.debug("about to screenshot because testcase is failed");
			try {
				
				String screenshotpath = TestUtil.capScreenshot(result.getName());
				test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception : "+result.getThrowable());
				test.log(LogStatus.FAIL,test.addScreenCapture(screenshotpath));
	
				Reporter.log("<a  target=\"_blank\" href=\""+screenshotpath+"\"> Click here to see screenshot </a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				Reporter.log("<a target=\"_blank\" href=\""+screenshotpath+"\"><img src=\""+screenshotpath+"\" height=200 width=200></img></a>");
				log.debug("Screenshot taken as testcase is failed");
				rep.endTest(test);
				rep.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		test = rep.startTest(arg0.getName().toUpperCase());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		// TODO Auto-generated method stub
		
		if(result.getStatus()==result.SUCCESS)
		{
			log.debug("about to screenshot because testcase is successfully passed");
			try {
				
				String screenshotpath = TestUtil.capScreenshot(result.getName());
				test.log(LogStatus.PASS,test.addScreenCapture(screenshotpath));
				
				
				
				Reporter.log("<a  target=\"_blank\" href=\""+screenshotpath+"\"> Click here to see screenshot </a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				Reporter.log("<a target=\"_blank\" href=\""+screenshotpath+"\"><img src=\""+screenshotpath+"\" height=200 width=200></img></a>");
				log.debug("Screenshot taken as testcase is successfully passed");
				//test = rep.startTest(result.getName().toUpperCase()+" PASS");
				test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
				rep.endTest(test);
				rep.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		MonitoringMail mail = new MonitoringMail();
		
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DatadrivenLiveProject/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
