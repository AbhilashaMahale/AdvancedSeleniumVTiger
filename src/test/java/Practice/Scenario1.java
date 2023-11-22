package Practice;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/*
 * package Practice;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
 */


//import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {
	
	public static void main(String[] args) throws Throwable{
		//launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login to app
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
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
		 driver.findElement(By.name("lastname")).sendKeys("Cruise");
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
