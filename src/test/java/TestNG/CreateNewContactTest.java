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
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
/////////////////**********PROGRAM32*******//////////
public class CreateNewContactTest {

	@Test	
	public static void createNewContact1Test () throws IOException, InterruptedException {
			
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
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
				
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
						
				
			    //Step3: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USN, PWD);
				
				//Step4: Login to Home Page
				HomePage hp = new HomePage(driver);
				hp.ClickOnContactsLnk();
				
				//Step5: Click on create contact look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLOOkUpIMG();
				Thread.sleep(1000);
				
				//Step6: Create new Contact details
				CreateNewContactPage cncp =new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
				//Thread.sleep(1000);
				
				//Step 7 : Validate
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String contactheader = cip.getContactHeader();
				if(contactheader.contains(LASTNAME)) {
					System.out.println(contactheader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("contact header not validated, FAIL");
				}
				
				//Step 8 :Logout
				hp.logoutOfApp(driver);
				
				//Step 9: close the browser
				driver.quit();
			
		}
		

	@Test
	public static void demo() {
		System.out.println("DEMO");
	}


}
