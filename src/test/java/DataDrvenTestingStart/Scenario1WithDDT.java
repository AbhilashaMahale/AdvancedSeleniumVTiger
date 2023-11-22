package DataDrvenTestingStart;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
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


//////****PROGRAM5*******In Class////////


public class Scenario1WithDDT {
	
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
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login to app
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USN);
	    driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
				
		
		//Navigate to Contacts link
		//driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
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
		driver.findElement(By.name("lastname")).sendKeys("LASTNAME");
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
		if(TextVal.contains("LASTNAME"))
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
