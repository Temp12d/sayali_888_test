package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locators.GoogleMapRepository;
import locators.GoogleSearchRepository;

/**
 * PageObjects for Google Map Page.
 * 
 * @author sekhe
 *
 */
public class GoogleMapPage extends GoogleMapRepository {

	GoogleMapRepository googleMapRepo;
	GoogleSearchRepository googleSearchRepo;
	GoogleSearchPage googleSearchPage;

	public WebDriver driver;

	/**
	 * Selection of Google Map Menu.
	 * 
	 * @param searchTerm 
	 * 			Term to search.
	 * 
	 */
	public void selectGoogleAppMenu(String searchTerm) {

		try {

			// Perform google search
			googleSearchPage.inputSearchTerm(searchTerm);

			// Selection of first search result.
			List<WebElement> elements = googleSearchRepo.searchResult;
			elements.get(0).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Verify presence of specific option under Google Map Menu.
	 * 
	 */
	public String verifyGoogleMapsMenu(String expectedOption) {
		
		String menuOption = null;

		try {
			
			// Click on Google Map Hamburger Menu.
			Thread.sleep(5000);
			googleMapRepo.googleMapHamburgerMenu.click();			
			
			// Get text of Google Map Menu Options. 
			List<WebElement> elements1 = googleMapMenuOptions;
			
			for (int i = 0; i < elements1.size(); i++) {
				
				menuOption = elements1.get(i).getText();				
				if(menuOption.equalsIgnoreCase(expectedOption) ) {
				return menuOption;
				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Initialize all elements in the Google Map page.
	 * 
	 * @param driver
	 * 			 The driver for the Browser that will run the application.
	 * 
	 * @throws Exception 
	 * 			 Exception encountered.
	 */
	public GoogleMapPage(WebDriver driver) {
		super(driver);
		googleMapRepo = new GoogleMapRepository(driver);
		googleSearchRepo = new GoogleSearchRepository(driver);
		googleSearchPage = new GoogleSearchPage(driver);
	}

}
