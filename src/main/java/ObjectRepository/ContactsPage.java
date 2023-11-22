package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//**********************PROGRAM27******************//////

public class ContactsPage {
	
	        //STEP 1: //DECLARATION
			
			@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Contact...']")
			private WebElement CreateContactLookUpImg;
			
			//STEP 2:INITIALISATION
		    //pick up search context and object
		    public ContactsPage(WebDriver driver) {
		   	 PageFactory.initElements(driver, this);
		    }


		    //Step 3:UTILISATION 
			
			public WebElement getCreateContactLookUpImg() {
				return CreateContactLookUpImg;
			}

			
			//CREATE BUSINESS LIBRARY
			public void clickOnCreateContactLOOkUpIMG() {
				CreateContactLookUpImg.click();
			}

}
