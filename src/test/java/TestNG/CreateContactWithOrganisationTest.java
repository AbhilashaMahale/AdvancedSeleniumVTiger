package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PorpertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewOrganisationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganisationInfoPage;
import ObjectRepository.OrganisationPage;
import io.github.bonigarcia.wdm.WebDriverManager;


/////////////////**********PROGRAM33*******//////////

public class CreateContactWithOrganisationTest {
	
	@Test
	public static void createContactWithOrganisation1Test () throws IOException, InterruptedException {


		//Create Object of all Utilities
        ExcelFileUtility eUtil = new ExcelFileUtility();
        PorpertyFileUtility pUtil = new PorpertyFileUtility();
        WebDriverUtility wUtil = new WebDriverUtility();
        JavaUtility jUtil = new JavaUtility();
        WebDriver driver = null;

        //Step 1:Read All required Data
	    /* Common Data */
		String BROWSER = pUtil.readDataFromPropertyFile("BROWSER");				
		String URL = pUtil.readDataFromPropertyFile("url");	
		String USN = pUtil.readDataFromPropertyFile("username");			
		String PWD = pUtil.readDataFromPropertyFile("password");
		
		//Step 3:load the data from Excel file				
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 5, 2)+jUtil.getRandomNumer();
		
		//Step 4: Launch the Browser
		//  This is run time Polymorphism -> Explained below
      // BROWSER will have the value chrome or firefox or edge if we run the script
		// once it takes the value in this if condition it gets compared, if condition is true the it enters particluar path
		// suppose driver holding the value firefox , it enters 2nd else if and launch the browser
		// so when it compared with type of the browser, "driver" starts to behave depending on the type 
		// of browser. this means "driver" is behaving in many ways i.e chrome or firefox etc.
		// hence "driver" is polymorphism
      
		if(BROWSER.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
				
		    
		}
		else if(BROWSER.equalsIgnoreCase("Chrome")){
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			
		} else if(BROWSER.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else {
			
			System.out.println("Invalid");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USN, PWD);
		
		//Navigate to Org Link
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrganisationLnk();
	
		
		//Click On Org LookUp Image
		OrganisationPage op = new OrganisationPage(driver);
		op.clickOnCreateOrganisationImg();
		
		//Create new Organisation
		CreateNewOrganisationPage cnop =new CreateNewOrganisationPage(driver);
		cnop.createNewOrganisation(ORGNAME);
		Thread.sleep(1000);
		
		//Validate for Oraganisation
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String orgheader = oip.getOrganisationHeader();
		if(orgheader.contains(ORGNAME)) {
			System.out.println(orgheader);
			System.out.println("Organisation created");
		}
		else {
			System.out.println("Organisation NOT created, FAIL");
		}
		
		//Navigate to Contacts
		hp.ClickOnContactsLnk();
		
		//Click on Create Contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLOOkUpIMG();
		Thread.sleep(1000);
		
		//create contact with organisation
		CreateNewContactPage cncp =new CreateNewContactPage(driver);
		cncp.createNewContacts(driver, ORGNAME, LASTNAME);
		
		//validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactheader = cip.getContactHeader();
		if(contactheader.contains(LASTNAME)) {
			System.out.println(contactheader);
			System.out.println("contact header validated PASS");
		}
		else
		{
			System.out.println("contact header not validated, FAIL");
		}
		
		//logout
		hp.logoutOfApp(driver);
		
		//close the browser
		driver.quit();

	}

}
