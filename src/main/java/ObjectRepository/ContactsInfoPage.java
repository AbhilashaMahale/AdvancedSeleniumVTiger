package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//**********************PROGRAM29******************//////
public class ContactsInfoPage {
	
	 //STEP 1: //DECLARATION
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	 private WebElement ContactHeaderText;
				  			
		
		//STEP 2:INITIALISATION
	    //pick up search context and object
	    public ContactsInfoPage(WebDriver driver) {
	   	 PageFactory.initElements(driver, this);
	    }


       //Step3: Utilisation


		public WebElement getContactHeaderText() {
			return ContactHeaderText;
		}
	    
	    
	    
	    
	    
		//CREATE BUSINESS LIBRARY
		/**
		 * This method will capture the header text and return it to caller
		 * @return
		 */
		public String getContactHeader() {
			return ContactHeaderText.getText();
		}



}
