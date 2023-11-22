package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

//**********************PROGRAM25******************//////

public class CreateNewOrganisationPage extends WebDriverUtility {
	
	
	 //STEP 1: //DECLARATION
	@FindBy(name = "accountname" )
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry" )
	private WebElement IndustryDropDown;
			
	@FindBy(name = "accounttype" )
	private WebElement tyepDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	 private WebElement SaveBtnt;
	
	//STEP 2:INITIALISATION
    //pick up search context and object
    public CreateNewOrganisationPage(WebDriver driver) {
   	 PageFactory.initElements(driver, this);
    }



    //Step 3:UTILISATION 
	
    public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}



	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}



	public WebElement getTyepDropDown() {
		return tyepDropDown;
	}



	public WebElement getSaveBtn() {
		return SaveBtnt;
	}

    
    
    
    
	
	//CREATE BUSINESS LIBRARY
	/**
	 * This method will create new organisation with mandatory files
	 * @param ORGNAME
	 */
	public void createNewOrganisation(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtnt.click();
	}
	
	


	/**
	 * This method will create new Organisation with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrganisation(String ORGNAME , String INDUSTRYNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown,INDUSTRYNAME);
		SaveBtnt.click();
	}

}
