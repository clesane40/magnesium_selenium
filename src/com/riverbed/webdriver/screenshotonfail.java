package com.riverbed.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.riverbed.library.Utility;

public class screenshotonfail 
{
	
	
	//Load web driver and reporting and logging framework
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	//
	//Create test method
	@Test
	public void riverbedsupport() throws InterruptedException
	{
	//Initialize reporting and logging for test method	
		report=new ExtentReports("C:\\Reports\\riverbedsupporthomepage.html",true);			
		
		logger=report.startTest("RiverbedSupport");
	//Initialize firefox web driver	
		driver=new FirefoxDriver();	
	//Open FF Browser and Maximize	
		driver.manage().window().maximize();
	//Log browser  start up after FF is opened and windows maximized as INFO message	
		logger.log(LogStatus.INFO, "Browser Started");
	//Get Support URL	
		driver.get("https://support.riverbed.com/");
	//Create variable named "connect" and set value to web driver method that gets the title of web page.  	
        String connect=driver.getTitle();
	//Use assertTrue method from the Assert class to verify that the page title contains a string. If the assertTrue is
    //false the test fails. 
		Assert.assertTrue(connect.contains("Riverbed Support"));
		
		logger.log(LogStatus.PASS, "Connected to Riverbed Support");		
		
		driver.findElement(By.id("supportForm_supportUsername")).sendKeys("charlie.lesane@riverbed.com");
		
		driver.findElement(By.id("supportForm_supportPassword")).sendKeys("DEnk%<8w7ot9");
		
		logger.log(LogStatus.INFO, "Username and Password Entered");	
		
		driver.findElement(By.className("submitcase-button")).click();
		
		//Thread.sleep(4000);
		
		String login=driver.getPageSource();
		
		Assert.assertTrue(login.contains("You are logged in as charlie.lesane@riverbed.com"));
		
		logger.log(LogStatus.PASS, "Login Successful");	
		
		driver.findElement(By.className("profile")).click();
		
		logger.log(LogStatus.INFO, "Go to Account Information");
		
		//String accountinfo=driver.getTitle();		
			
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("Log Out")).click();
	
		
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
		String screenshot_path=Utility.captureScreenshot(driver, result.getName());
		logger.log(LogStatus.FAIL,"Test Failed",screenshot_path);
		
		}
		
       	report.endTest(logger);
		report.flush();
		
		driver.get("C:\\Reports\\riverbedsupporthomepage.html");
		
		Thread.sleep(8000);
		
		driver.quit();
		
	
		
	
	}
}