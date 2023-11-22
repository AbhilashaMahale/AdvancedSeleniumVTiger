package ScenarioswithDDTAndGeneralUtilityAndObjectReposirtory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PorpertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


/////////////////////////*******Program22***///////////////////////////

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException, IOException {
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
			
		
			//login to app
			driver.get(URL);			
		    //Replaced with Object Repository
			LoginPage Ip = new LoginPage(driver);
			//Ip.getUserNameEdt().sendKeys(USN);
			//Ip.getUserPwdEdt().sendKeys(PWD);
			//Ip.getLoginBtn().click();
			
			///OR
			// If I create Business LIbarry, code will get optimised liek shown below
			Ip.loginToApp(USN, PWD);
			
		     
			
			//Navigate to Contacts link
			//driver.findElement(By.linkText("Contacts")).click();
			//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			HomePage Hp = new HomePage(driver);
            Hp.getContactsLnk().click();
			Thread.sleep(5000);
					
			//Click on Create contact look Up Image
			//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Contact...']")).click();
					
					
			//to select the FirstName Mr/Mrs from the List
			Thread.sleep(1000);
			WebElement NameList = driver.findElement(By.name("salutationtype"));
			//Select NameSet = new Select(NameList);
			Select NameSet = new Select(NameList);
			NameSet.selectByValue("Mrs.");
			Thread.sleep(5000);
					 
			// to write last name
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Cruise");
			Thread.sleep(500);
					 
			//to check box the Assigned to button[user/group option]
			WebElement checkbox = driver.findElement(By.xpath("//input[@value='T']"));
			checkbox.click();
		    Thread.sleep(500);
					 
			//save the file
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(5000);
					 
		    //Validate
			//validate whether the cruise is saved or not?
			//using get Text for confirmation
			String TextVal = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(TextVal.contains(LASTNAME))
			{
				System.out.println(TextVal);
				System.out.println("LAST Names is Saved ,PASS");
			}
			else {
			    System.out.println("LAST Names is NOT Saved ,Fail");			 			 
				}

			//logout
			//first need to do mouse over action on the image
			//its is not a direct action, need to use Action class concept
			
			 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 wUtil.mouseHoverAction(driver, ele);
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		     System.out.println("Logout is succcessful");

	}

}
