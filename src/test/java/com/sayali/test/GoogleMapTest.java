package com.sayali.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sayali.test.base;

import pageObjects.GoogleMapPage;


/**
 * Case 3: Assert "Flat Earth View" option of Google Map
 * 
 * @author Sayali Ekhe
 */
public class GoogleMapTest extends base
{	
	   @BeforeClass
	    public void launchBrowser() throws IOException {
	    
		   // Initialize driver
	    driver = initializeDriver();  	       
	    	
	    }

	    @AfterClass
	    public void afterClass() {
	    	
	    	//driver.close();
	        driver.quit();
	    }
	    
	/**
	 * To verify that particular option is not present under google map HamburgerMenu.
	 * 
	 * @throws IOException
	 * 		 Exception encountered.
	 * @throws InterruptedException 
	 */
	    @Test
	    public void CH05_verifyMapMenuOptionNotPresent() throws IOException, InterruptedException {
	      
	    	String searchTerm = "Google Maps";
	    	String expectedOption = "Flat Earth View";
	    	driver.get("http://www.google.com");	       
	    	GoogleMapPage gm = new GoogleMapPage(driver);
	    	    	
	    	gm.selectGoogleAppMenu(searchTerm);
	    	String menuOption = gm.verifyGoogleMapsMenu(expectedOption);
	    	
	    	Assert.assertFalse(menuOption.contains(expectedOption));

	    }
	    
	    /**
		 * To verify that particular option is present under google map HamburgerMenu.
		 * 
		 * @throws IOException
		 * 		 Exception encountered.
		 * @throws InterruptedException 
		 */
		    @Test
		    public void CH06_verifyMapMenuOptionPresent() throws IOException, InterruptedException {
		      
		    	String searchTerm = "Google Maps";
		    	String expectedOption = "Globe";
		    	driver.get("http://www.google.com");	       
		    	GoogleMapPage gm = new GoogleMapPage(driver);
		    	    	
		    	gm.selectGoogleAppMenu(searchTerm);
		    	String menuOption = gm.verifyGoogleMapsMenu(expectedOption);
		    	
		    	Assert.assertTrue(menuOption.contains(expectedOption));

		    }
	    
}
