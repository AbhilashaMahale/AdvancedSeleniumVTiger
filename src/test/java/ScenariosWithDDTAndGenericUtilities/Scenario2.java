package ScenariosWithDDTAndGenericUtilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PorpertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

//**********************PROGRAM17******************//////

public class Scenario2 {
	
	public static void main(String[] args)throws Throwable {
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
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();	
		    
		}
		else if(BROWSER.equalsIgnoreCase("Chrome")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
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
		driver.findElement(By.name("user_name")).sendKeys(USN);
	    driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		//Navigate to Organizations link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Thread.sleep(5000);
		
		//Click on Create Organization look Up Image
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Organization...']")).click();
		Thread.sleep(500);
		
		//Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		Thread.sleep(500);
		
		//save the file
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //Validate
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
