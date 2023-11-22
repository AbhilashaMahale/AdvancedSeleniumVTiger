package DataDrvenTestingStart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

//////****PROGRAM9*******Assigment////////
public class Scenario5WithDDT {

	public static void main(String[] args) throws IOException, Exception {
		//Step 1:Read All required Data
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p = new Properties();
				p.load(fis);
				
				//Step 2: load the data from property file		
				String BROWSER = p.getProperty("BROWSER");				
				String URL = p.getProperty("url");	
				String USN = p.getProperty("username");			
				String PWD = p.getProperty("password");
				
				//Step 3:load the data from Excel file
				FileInputStream fos = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fos);
				String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
				
				WebDriver driver = null;
				//Step 4: Launch the Browser	
		       
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
				
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//login to app
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USN);
			    driver.findElement(By.name("user_password")).sendKeys(PWD);
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(1000);
				
				//Navigate to Contacts link
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				Thread.sleep(5000);
				
				//Click on Create contact look Up Image
				driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Contact...']")).click();
				
				
				//to select the FirstName Mr/Mrs from the List
				Thread.sleep(1000);
				 WebElement NameList = driver.findElement(By.name("salutationtype"));
				 Select NameSet = new Select(NameList);
				 NameSet.selectByValue("Mrs.");
				 Thread.sleep(5000);
				 
				 // to write last name
				 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Cruise");
				 Thread.sleep(500);
				 
				 //to check box the Assigned to button[user/group option]
				 WebElement checkbox = driver.findElement(By.xpath("//input[@value='T']"));
				 checkbox.click();
				 Thread.sleep(500);
				 
				//Select the Organization from organization look up image
				driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
			  
				//Capture the Main/Parent Window ID
				String MainWindowID = driver.getWindowHandle();
				
				//Capture the All windows -> main ID and Child Window ID
				Set<String> allWindowsID1 = driver.getWindowHandles();
				System.out.println(allWindowsID1);
				
				//
				for(String id:allWindowsID1) { //parent and child Id all capture through loop
				 	if(!MainWindowID.equals(id)) { //to match if parent ID != child ID
				 		driver.switchTo().window(id);	
				 		Thread.sleep(1000);
				 		
				 	}
				 }
				
				//Search for Organisation in window ID
				driver.findElement(By.name("search_text")).sendKeys("Talent Aquisitions");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText("Talent Aquisitions")).click();
				
				//Switch back to Main window
				driver.switchTo().window(MainWindowID);
				
				//save the file
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(5000);
				 
				 //Validate
				 //validate whether the cruise is saved or not?
				 //using get Text for confirmation
				 String TextVal = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 if(TextVal.contains("Cruise"))
				 {
					 System.out.println(TextVal);
					 System.out.println("PASS");
				 }
				 else {
					 System.out.println("Fail");			 			 
				 }

				 //logout
		        //first need to do mouse over action on the image
		        //its is not a direct action, need to use Action class concept
		        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions act = new Actions(driver);
		        act.moveToElement(ele).perform();
		        Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("Logout is succcessful");

	}

}
