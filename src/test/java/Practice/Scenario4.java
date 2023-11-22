package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {
	
	public static void main(String[] args)throws Throwable {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		//Thread.sleep(500);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		Thread.sleep(500);
		
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
