package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//**********************PROGRAM24******************//////

public class OrganisationPage {
	
	
	    //STEP 1: //DECLARATION
	   @FindBy(xpath = "//img[@alt='Create Organization...']")
	   private WebElement CreateOrganisationImg;
		
		//STEP 2:INITIALISATION
	    //pick up search context and object
	    public OrganisationPage(WebDriver driver) {
	   	 PageFactory.initElements(driver, this);
	    }


	    //Step 3:UTILISATION 
	    public WebElement getCreateOrganisationImg() {
			return CreateOrganisationImg;
		}

		
	    //Create Business LIBRARY
	    public void clickOnCreateOrganisationImg() {
	    	CreateOrganisationImg.click();
		}

}
