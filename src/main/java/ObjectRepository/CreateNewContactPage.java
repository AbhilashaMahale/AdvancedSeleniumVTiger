package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

//**********************PROGRAM28******************//////

public class CreateNewContactPage extends WebDriverUtility{
	
	 //STEP 1: //DECLARATION
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	 private WebElement SaveBtnt;
	 
	 @FindBy(xpath = "(//img[@alt='Select'])[1]")
	 private WebElement OrgLookUpImg;
	 
	 @FindBy(name = "search_text")
	 private WebElement OrgSearchEdt;	 	

	 @FindBy(name = "search")
	 private WebElement OrgSearchBtn;

		
		//STEP 2:INITIALISATION
	    //pick up search context and object
	    public CreateNewContactPage(WebDriver driver) {
	   	 PageFactory.initElements(driver, this);
	    }


	    //Step 3:UTILISATION 
	    public WebElement getLastNameEdt() {
			return LastNameEdt;
		}


		public WebElement getSaveBtnt() {
			return SaveBtnt;
		}


		public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}


		public WebElement getOrgSearchEdt() {
			return OrgSearchEdt;
		}


		public WebElement getOrgSearchBtn() {
			return OrgSearchBtn;
		}
		
		
		//CREATE BUSINESS LIBRARY
		/**
		 * This method will create contact with mandatory fields  and save 
		 * @param LASTNAME
		 */
		public void createNewContact(String LASTNAME) {
			LastNameEdt.sendKeys(LASTNAME);
			SaveBtnt.click();
		}
		
		/**
		 * This method will create contact by choosing the organisation
		 * @param driver
		 * @param ORGNAME
		 * @param LASTNAME
		 */
		public void createNewContacts(WebDriver driver,String ORGNAME,String LASTNAME) {
			LastNameEdt.sendKeys(LASTNAME);
			OrgLookUpImg.click();
			switchToWindow(driver,"Accounts");
			OrgSearchEdt.sendKeys(ORGNAME);
			OrgSearchBtn.click();
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
			switchToWindow(driver,"Contacts");
			SaveBtnt.click();
		}
		

}
