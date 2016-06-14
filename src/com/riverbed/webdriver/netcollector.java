package com.riverbed.webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.riverbed.library.Utility;

import java.io.IOException;
import org.openqa.selenium.By;

public class netcollector {
	
	@Test
	public void netcollector_hp() throws IOException
	{
		
		WebDriver driver=new FirefoxDriver();
		
		Utility.captureScreenshot(driver,"Open FF");
		
		driver.manage().window().maximize();
		
		Utility.captureScreenshot(driver,"Max FF Window");
		
		driver.get("http://nc-win-tslab5:9190/vnes");
		
		Utility.captureScreenshot(driver,"NetCollector Homepage");
		
		driver.findElement(By.id("usernameField")).sendKeys("admin");		
		
		Utility.captureScreenshot(driver,"Enter username");
	
		driver.quit();
				
	}
}
