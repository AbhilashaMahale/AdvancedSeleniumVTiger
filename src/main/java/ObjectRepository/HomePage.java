package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;


//**********************PROGRAM23******************//////

public class HomePage extends WebDriverUtility {
	
	//STEP 1: //DECLARATION
	@FindBy(linkText = "Organizations")
	private WebElement OrganisationLnk;
			

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private  WebElement administatorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	


	
	//STEP 2:INITIALISATION
    //pick up search context and object
    public HomePage(WebDriver driver) {
   	 PageFactory.initElements(driver, this);
    }


 // Step 3:UTILISATION 
	public WebElement getOrganisationLnk() {
		return OrganisationLnk;
	}


	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

    
	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	
	public WebElement getadministatorImg() {
		return administatorImg;
	}
	
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
    
	
	
	
	//CREATE BUSINESS LIBRARY
     /**
      * `THIS METHOD WILL CLICK ON ORGANISATION LINK
      */
    
	public void ClickOnOrganisationLnk() {
		OrganisationLnk.click();
	}
    
	/**
	 * THIS METHOD WILL CLICK ON CONTATCS LINK
	 *
	 */
	public void ClickOnContactsLnk() {
		ContactsLnk.click();
	}
	
	/**
	 *  THIS METHOD WILL CLICK ON PRODUCTS LINK
	 */
	public void ClickOnProductsLnk() {
		ProductsLnk.click();
	}
    
	/**
	 * This method will logout of application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logoutOfApp(WebDriver driver ) throws InterruptedException {
		
		mouseHoverAction(driver, administatorImg);
		Thread.sleep(1000);
		SignOutLnk.click();
	}
}
