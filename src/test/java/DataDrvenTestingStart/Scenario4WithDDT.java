package DataDrvenTestingStart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//////****PROGRAM8*******Assigment////////
public class Scenario4WithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		
		//Navigate to Organizations link
				driver.findElement(By.xpath("//a[text()='Organizations']")).click();
				Thread.sleep(5000);
				
				//Click on Create Organization look Up Image
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@title='Create Organization...']")).click();
				Thread.sleep(500);
				
				//Create Organization with Mandatory fields
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Talent Aquisitions");
				Thread.sleep(500);
				
				//Select "Chemicals" in the industry drop down
				WebElement IndustryTypeList = driver.findElement(By.name("industry"));
				Select IndustryTypeSet = new Select(IndustryTypeList);
				IndustryTypeSet.selectByValue("Energy");
				
				//Select "Customer" in the Type Drop down 
				WebElement TypeList = driver.findElement(By.name("accounttype"));
				Select TypeSet = new Select(TypeList);
				TypeSet.selectByValue("Customer");
				
				//save the file
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 
				 
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
