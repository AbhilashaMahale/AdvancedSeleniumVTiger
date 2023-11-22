package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//**********************PROGRAM26******************//////

public class OrganisationInfoPage {
	
	   //STEP 1: //DECLARATION
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	   private WebElement OrganisationHeaderText;

	
	    //STEP 2:INITIALISATION
        //pick up search context and object
        public OrganisationInfoPage(WebDriver driver) {
   	    PageFactory.initElements(driver, this);
        }
	

        //Step 3:UTILISATION 
        public WebElement getOrganisationHeaderText() {
		return OrganisationHeaderText;
	    }
    
    
        //CREATE BUSINESS LIBRARY
  		/**
  		 * This method will capture the header text and return it to caller
  		 * @return
  		 */
  		public String getOrganisationHeader() {
  			return OrganisationHeaderText.getText();
  		}


}
