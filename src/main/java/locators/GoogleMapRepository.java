package locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMapRepository {

	// Google Map Xpath
	
	public final String googleMapHamburgerMenuXpath = "//div[contains(@class,'searchbox-hamburger')]";  
	public final String googleMapMenuOptionsXpath  = "//label[@class='widget-settings-button-label']";
	
	
	// Google Map WebElement
		 
	 @FindBy(xpath = googleMapHamburgerMenuXpath)
	    public WebElement googleMapHamburgerMenu;
		 
	 @FindBy(xpath = googleMapMenuOptionsXpath)
	    public List<WebElement> googleMapMenuOptions;
			

	 public GoogleMapRepository(WebDriver driver) {
	        try {
	            // Create all 'WebElements'
	            PageFactory.initElements(driver, this);
	        } catch (Exception ex) {
	            // Log and throw the error
	            throw ex;
	        }
	    }
}
