package ScenariosWithDDTAndGenericUtilities;

import java.io.FileInputStream;


import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PorpertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

//**********************PROGRAM20*****************//////

public class Scenario5 {

	public static void main(String[] args) throws IOException, InterruptedException {

		  //Step1 : Create Object of all Utilities
	      ExcelFileUtility eUtil = new ExcelFileUtility();
	      PorpertyFileUtility pUtil = new PorpertyFileUtility();
	      WebDriverUtility wUtil = new WebDriverUtility();
	      JavaUtility jUtil = new JavaUtility();
	      WebDriver driver = null;
	
	      //Step 2:Read All required Data
		  /* Common Data */
		  String BROWSER = pUtil.readDataFromPropertyFile("BROWSER");				
		  String URL = pUtil.readDataFromPropertyFile("url");	
			String USN = pUtil.readDataFromPropertyFile("username");			
			String PWD = pUtil.readDataFromPropertyFile("password");
			
			//Step 3:load the data from Excel file				
			String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
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
		
		//Step 5: login to app
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USN);
	    driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		//Step 6: Navigate to Organizations link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Thread.sleep(5000);
				
		//Step 7: Click on Create Organization look Up Image
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Organization...']")).click();
		Thread.sleep(500);
				
		//Step 8: Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		Thread.sleep(500);
				
		//Step 9: save the file
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(500);		 
		//Step 10: Validate
		//validate whether the Organisation is created Or Not
		//using get Text for confirmation
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
		    System.out.println(OrgHeader);
			System.out.println("PASS, Organisation created");
		}
	   else 
	   {
		    System.out.println("Fail, Organisation Not created");	
			
	   }
		
		//Step 11:Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(5000);
		
		//Step 12:Click on Create contact look Up Image
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Contact...']")).click();
		
		
		//Step 13:to select the FirstName Mr/Mrs from the List
		Thread.sleep(1000);
		 WebElement NameList = driver.findElement(By.name("salutationtype"));
		 Select NameSet = new Select(NameList);
		 NameSet.selectByValue("Mrs.");
		 Thread.sleep(5000);
		 
		 //Step 14: to write last name
		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		 Thread.sleep(500);
		 
		 //Step 15:to check box the Assigned to button[user/group option]
		 WebElement checkbox = driver.findElement(By.xpath("//input[@value='T']"));
		 checkbox.click();
		 Thread.sleep(500);
		 
		//Step 16:Select the Organization from organization look up image
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
	  
		//Step 17:Switch Control to Child Window
		wUtil.switchToWindow(driver, "Accounts");//Accounts is the common name found in child window url
		System.out.println("Switched to Child Window");
		
		//Step 18:Search for organisation
		//Search for Organisation in Child window ID
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		//Dynamic Xpath -> Refer Thursday 12-10-2023 book notes for more info
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		                         //a[.='"+infosys515+"']"
		                         //a[.='"+infosys1000+"']"
		//OR driver.findElement(By.linkText(ORGNAME));
		
		//Step 19: Switch back to Main window
		wUtil.switchToWindow(driver, "Contacts");
		System.out.println("Switched back to Main Window");
		
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
			 System.out.println("PASS, Contacts created");
		 }
		 else {
			 System.out.println("Fail,Contacts not created");			 			 
		 }

		 //logout
        //first need to do mouse over action on the image
        //its is not a direct action, need to use Action class concept
		// Step 14: Logout
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, ele);
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout is successfull");
		

	}

}
