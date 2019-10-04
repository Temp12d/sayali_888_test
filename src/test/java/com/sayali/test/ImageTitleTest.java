package com.sayali.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sayali.test.base;

import pageObjects.GoogleSearchPage;

/**
 * Case 2: Confirm the first image title contains the phrase "Dealey Plaza"
 * 
 * @author sekhe
 *
 */
public class ImageTitleTest extends base {
	@BeforeClass
	public void launchBrowser() throws IOException {

		// Initialize driver.
		initializeDriver();

	}

	@AfterClass
	public void afterClass() {

		// Quit driver.
		driver.quit();
	}

	/**
	 * To verify if image title contains particular search term.
	 * 
	 * @throws IOException 
	 * 			Exception encountered.
	 */
	@Test
	public void CH03_verifyContainsImageTitle() throws IOException {

		driver.get("http://www.google.com");
		GoogleSearchPage gs = new GoogleSearchPage(driver);
		String search_text = "Dealey Plaza";

		String text1 = gs.verifyContainsTerm(search_text);
		Assert.assertTrue(text1.contains(search_text));
	}

	/**
	 * To verify if image title does not contain particular term.
	 * 
	 * @throws IOException Exception encountered.
	 */
	@Test
	public void CH04_verifyDoesNotContainImageTitle() throws IOException {

		driver.get("http://www.google.com");
		GoogleSearchPage gs = new GoogleSearchPage(driver);
		String search_text = "Dealey Plazaqqqqqwertyu";

		String text1 = gs.verifyContainsTerm(search_text);
		Assert.assertFalse(text1.contains(search_text));

	}
}
