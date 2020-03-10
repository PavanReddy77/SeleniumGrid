package com.Grid.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest1 
{
	public static WebDriver driver;
	
	@Test
	public void chromeTest1() throws MalformedURLException
	{		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(capabilities);
		
		String hubUrl = "http://localhost:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.github.com");
		
		String title = driver.getTitle();
		System.out.println("The ChromeTest_1 Github Title is ::: " +title);
		
		driver.quit();
	}
} 
