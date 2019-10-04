package locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchRepository {

	// Text Contains Xpath
	public final String googleSearchBoxXpath = "//input[@title='Search']";
	public final String searchResultXpath = "//h1[text()='Search Results']/ancestor::div[1]//h3/div";
	public final String searchButtonXpath = "//div[@class='FPdoLc VlcLAe']//input[@name='btnK']";
	public final String searchSuggestionXpath = "//ul//li[1]//span[text()='chemtrails']";
	
	// Image Title Xpath
	public final String imageTitleXpath = "//img[contains(@alt,'Dealey Plaza')]/ancestor::div[1]//a[2]/div[1]";
	
	  
	// Text Contains WebElement
	 @FindBy(xpath = googleSearchBoxXpath)
	    public WebElement googleSearchBox;
	 
	 @FindBy(xpath = searchResultXpath)
	    public List<WebElement> searchResult;
	 
	 @FindBy(xpath = searchButtonXpath)
	    public WebElement searchButton;
	
	 @FindBy(xpath = searchSuggestionXpath)
	    public WebElement searchSuggestion;
	 
	 
	// Image Contains WebElement
	 @FindBy(xpath = imageTitleXpath)
	    public WebElement imageTitle;
	
	
		 
	 
	 

		
//	public List<WebElement> searchResult() throws Exception {
//		
//		return  driver.findElements(searchResultXpath);
//	} 
//	

	 public GoogleSearchRepository(WebDriver driver) {
	        try {
	            // Create all 'WebElements'
	            PageFactory.initElements(driver, this);
	        } catch (Exception ex) {
	            // Log and throw the error
	            throw ex;
	        }
	    }
}
