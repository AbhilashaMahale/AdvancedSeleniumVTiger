package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/////////////////////////*******Program21 ***///////////////////////////

public class LoginPage { //Rule 1
	
	//STEP 1: //DECLARATION
	@FindBy(name = "user_name")
    private WebElement userNameEdt;//Edt for text, btn for button, lnk for link

     @FindBy(name = "user_password")
     private WebElement userPwdEdt;
     
     @FindBy(id = "submitButton")
     private WebElement loginBtn;

	
     
     //STEP 2:INITIALISATION
     //pick up search context and object
     public LoginPage(WebDriver driver) {
    	 PageFactory.initElements(driver, this);
     }
     
     // Step 3:UTILISATION    		 
     //right click on class - source - generate getter and setter , clock on it
     //click on select getters
     public WebElement getUserNameEdt() {
 		return userNameEdt;
 	}

 	public WebElement getUserPwdEdt() {
 		return userPwdEdt;
 	}

 	public WebElement getLoginBtn() {
 		return loginBtn;
 	}
 	
 	//once this is done go to any scenarios ex -> scenario1
 	// replace the login details with getter methods
 	//src/test/java - package ScenarioswithDDTAndGeneralUtilityAndObjectReposirtory;
 	// class Scenario1
 	
 	//BUsineLibrary -> Generic methods using the webelements in current
 	// WHEN WE CAN CREATE LIBRARIES WHAT IS THE USE OF GETTER METHODS THEN
 	// LIBRARIES are OPTIONAL BUT getter methods are mandatory
 	// libraries are used to generalsie the code and also being how best coder you are
 	// hence attempting libraries need strong java knowledge
 	/**
 	 * This method will login to application
 	 * @param USERNAME
 	 * @param PASSWORD
 	 */
 	public void loginToApp(String USERNAME,String PASSWORD) {
 		userNameEdt.sendKeys(USERNAME);
 		userPwdEdt.sendKeys(PASSWORD);
 		loginBtn.click();
 	}
 	
 	
}
