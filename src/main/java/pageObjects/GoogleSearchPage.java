package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locators.GoogleSearchRepository;

/**
 * PageObjects for Search Page.
 * 
 * @author sekhe
 *
 */
public class GoogleSearchPage extends GoogleSearchRepository {

	GoogleSearchRepository googleSearchRepo;

	/**
	 * Access text of first element.
	 * 
	 * @param searchTerm 
	 * 			Term to search.
	 * @return Text 
	 * 			Text of first element.
	 */
	public String verifyContainsTerm(String searchTerm) {
		String text = null;
		try {

			// Input Search Term.
			inputSearchTerm(searchTerm);

			// Get text of first search result.
			List<WebElement> elements = searchResult;
			text = elements.get(0).getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;

	}

	/**
	 * Access Title of First Image Title.
	 * 
	 * @param searchTerm Term to search.
	 * 
	 * @return Title of first element.
	 */
	public String verifyFirstImageTitle(String searchTerm) {
		String text = null;
		try {

			// Input Search Term.
			inputSearchTerm(searchTerm);

			// Get text of first Image result.
			List<WebElement> elements = searchResult;
			text = elements.get(0).getText();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;

	}

	/*
	 * Perform Google Search
	 */
	public String inputSearchTerm(String searchTerm) {
		try {
			googleSearchRepo.googleSearchBox.sendKeys(searchTerm);
			googleSearchRepo.googleSearchBox.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchTerm;
	}

	/**
	 * Initialize all elements in the Google Search page.
	 * 
	 * @param driver The driver for the Browser that will run the application
	 * 
	 * @throws Exception Exception encountered
	 */
	public GoogleSearchPage(WebDriver driver) {
		super(driver);
		googleSearchRepo = new GoogleSearchRepository(driver);
	}

}
