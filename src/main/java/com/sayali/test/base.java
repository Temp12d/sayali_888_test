package com.sayali.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Pick the driver based on the browser to be used for tests.
 * 
 * @author sekhe
 *
 */
public class base{
	
	// Web Driver
	public WebDriver driver;
	
	
	/*
	 * Set the driver based on the Browser type.
	 */
	public WebDriver initializeDriver() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("../SayaliSelenium-app/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		 // Set chrome driver.
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","../SayaliSelenium-app/DriverSetup/chromedriver.exe");
			driver= new ChromeDriver();
		}
		 // Set firefox driver.
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","../SayaliSelenium-app/DriverSetup/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Window maximize.
		driver.manage().window().maximize();
		return driver;
	}
	
	
}