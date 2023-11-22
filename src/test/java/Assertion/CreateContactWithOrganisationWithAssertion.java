package Assertion;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
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




////////////////////////********************PROGRAM38************HOMEWORK////////////////////////////////////


public class CreateContactWithOrganisationWithAssertion extends BaseClass{
	
	
	@Test
	public void createContactWithOrganisation1Test () throws IOException, InterruptedException {


		//Step 3:load the data from Excel file				
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 5, 2)+jUtil.getRandomNumer();

		
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
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(orgheader);
	    System.out.println("Organisation created");
		
		
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
		Assert.assertTrue(contactheader.contains(LASTNAME));
		System.out.println(contactheader);
		System.out.println("contact header validated PASS");
		
		


	}

}
