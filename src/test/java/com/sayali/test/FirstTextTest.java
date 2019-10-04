package com.sayali.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sayali.test.base;

import pageObjects.GoogleSearchPage;

/**
 * Case 1: Confirm the first text entry contains the word "Chemtrails"
 * 
 * @author Sayali Ekhe
 */

public class FirstTextTest extends base {
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
	 * To verify if search result contains particular term.
	 * 
	 * @throws IOException          
	 * 			Exception encountered
	 * @throws InterruptedException 
	 * 			Exception encountered
	 */
	@Test
	public void CH01_verifyContainsSearchTerm() throws IOException, InterruptedException {
		GoogleSearchPage gs = new GoogleSearchPage(driver);

		driver.get("http://www.google.com");

		String search_text = "Chemtrail";

		String text1 = gs.verifyContainsTerm(search_text);
		Assert.assertTrue(text1.contains(search_text));

	}

	/**
	 * To verify that search result does not contain particular term.
	 * 
	 * @throws IOException          
	 * 			Exception encountered
	 * @throws InterruptedException 
	 * 			Exception encountered
	 */
	@Test
	public void CH02_verifyDoesNotContainSearchTerm() throws IOException, InterruptedException {
		GoogleSearchPage gs = new GoogleSearchPage(driver);

		driver.get("http://www.google.com");

		String search_text = "Chemtrailqwertyui";

		String text1 = gs.verifyContainsTerm(search_text);
		Assert.assertFalse(text1.contains(search_text));

	}
}
