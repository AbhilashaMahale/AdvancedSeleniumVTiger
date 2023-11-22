package ForListeners;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
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


//Before this in Generic ZUtlities package-> Listeners Implementaion classs is created i.e PGM 44
////////////////////////********************PROGRAM45************////////////////////////////////////

@Listeners(GenericUtilities.ListenersImplementation.class)

public class CreateContactForListenersConceptForPass extends BaseClass {
	
	
	@Test	
	public  void createNewContactTest () throws IOException, InterruptedException {
		
				//Step 3:load the data from Excel file				
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
				
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
	
		}

}
