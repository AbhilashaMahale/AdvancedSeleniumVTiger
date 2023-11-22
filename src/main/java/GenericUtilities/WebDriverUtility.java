package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

//////*******************************PROGRAM15****************************************In Class////////

public class WebDriverUtility {
	
	//WebDriver driver; we are not doing this as we are not launching the browser 
	//here,if we use global declaration the we cannot use driver.manage or driver.quit()
	//hence we are sending parameterized
	
	/**
	 * method1
	 * this method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	/**
	 * method2
	 * this method will minimize the window
	 * @param driver
	 */
	
      public void minimizeWindow(WebDriver driver) {
		
		driver.manage().window().minimize();
	}
      
      /**
       * WAITS
       * method3
       * this method will wait for 10 seconds for the web page to get loaded
       * 
       * @param driver
       */
      public void waitForPageLoad(WebDriver driver) {
    	  
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  
      }
      
      /**
       * WAITS
       * method4
       * This method will wait for 10 seconds for the element to be visible
       * @param driver
       * @param element
       */
      public void waitForElementTobeVisible(WebDriver driver, WebElement element) {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.visibilityOf(element));
      }
      
      /**
       * WAITS
       * method5
       * This method will wait for 10 seconds for the element to be clickable
       * @param driver
       * @param element
       */
      
      public void waitForElementTobeclickable(WebDriver driver, WebElement element) {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.elementToBeClickable(element));
      }
      
      /**
       * WAITS
       * method6
       * This method will wait for 10 seconds for the element to be clickable
       * @param driver
       * @param Title
       */
      
      public void waitForElementTobetitleContains(WebDriver driver, String Title) {
    	  
    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.titleContains(Title));
      }
      
      /**
       * Select Class
       * METHOD OVERLOADING
       * method7
       * This method will handle drop-down by index
       * @param element
       * @param index
       */
      
      public void handleDropDown(WebElement element, int index) {
    	  Select sel = new Select(element);
    	  sel.selectByIndex(index);
      }
      
      /**
       * Select Class
       * METHOD OVERLOADING
       * method8
       * This method will handle drop-down by Value
       * @param element
       * @param value
       */
      
      public void handleDropDown(WebElement element, String value) {
    	  Select sel1 = new Select(element);
    	  sel1.selectByValue(value);
      }
      
      /**
       * Select Class
       * METHOD OVERLOADING
       * method9
       * This method will handle drop-down by Visible Text
       * @param element
       * @param Text
       */
      public void handleDropDown(String Text,WebElement element) {
    	  Select sel2 = new Select(element);
    	  sel2.selectByVisibleText(Text);
      }
      
     /**
      * Action Class
      * method10
      * This method will perform drag and drop
      * @param driver
      * @param drag
      * @param drop
      */
      public void ActionClassDragDrop(WebDriver driver,WebElement drag, WebElement drop) {
    	  Actions act = new Actions(driver);
    	  act.dragAndDrop(drag, drop).perform();
    	  
      }
      
      /**
       * Action Class
       * method 11
       * This method will perform mouse hovering action
       * @param driver
       * @param element
       */
      public void mouseHoverAction(WebDriver driver,WebElement element) {
    	  Actions act = new Actions(driver);
    	  act.moveToElement(element).perform();
      }
      
      /**
       * Action Class
       * method 12
       * This method will perform double click on the element
       * @param driver
       * @param element
       */
      public void doubleClickAction(WebDriver driver,WebElement element) {
    	  Actions act = new Actions(driver);
    	  act.doubleClick(element).perform();
      }
      
      /**
       * Action Class
       * method 13
       * This method will perform Right click on the element
       * @param driver
       * @param element
       */
      public void rightClickAction(WebDriver driver,WebElement element) {
    	  Actions act = new Actions(driver);
    	  act.contextClick(element).perform();
    	  
      }
      
      /**
       * Action Class
       * method 14
       * This method will perform click And Hold Action on the element
       * @param driverContext
       * @param element
       */
      public void clickAndHoldAction(WebDriver driver,WebElement element) {
    	  Actions act = new Actions(driver);
    	  act.clickAndHold(element).perform();
    	  
      }
      
      /**
       * Scroll
       * method 15
       * This method will perform Scroll Down for 500units
       * @param element
       */
      
      public void scrollDOwnAction(WebDriver driver) {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("Window.scrollBy(0,500)", "");
      }
      
      
      /**
       * Scroll
       * method 16
       * This method will perform Scroll UP for 500units
       * @param element
       */
      public void scrollUpAction(WebDriver driver) {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("Window.scrollBy(0,-500)", "");
      }
      
      
      /**
       * Scroll
       * method 17
       * This method will perform Scroll Left for 500units
       * @param element
       */
      public void scrollLeftAction(WebDriver driver) {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("Window.scrollBy(500,0)", "");
      }
      
      /**
       * Scroll
       * method 18
       * This method will perform Scroll Right for 500units
       * @param element
       */
      public void scrollRightAction(WebDriver driver) {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	  js.executeScript("Window.scrollBy(-500,0)", "");
      }
      
      /**
       * Alert Pop Up
       * method 19
       * This method will accept the alert Pop Up
       * @param driver
       */
      public void AlertPopUpAccept(WebDriver driver) {
        driver.switchTo().alert().accept();;
      }
      
      /**
       * Alert Pop Up
       * method 20
       * This method will Dismiss the alert Pop Up
       * @param driver
       */
      public void AlertPopUpDismiss(WebDriver driver) {
          driver.switchTo().alert().dismiss();
          }
      
      /**
       * Alert Pop Up
       * Method 21
       * This method will capture the alert text and return to caller
       * @param driver
       * @return
       */
      
      public String getAlertText(WebDriver driver) {
    	  String Text = driver.switchTo().alert().getText();
    	  return Text;
      }
      
      /**
       * Frames
       * Method 22
       * This method will switch To Frame based on index
       * @param driver
       * @param index
       */
      public void switchToFrame(WebDriver driver, int index) {
    	  driver.switchTo().frame(index);
      }
      
      /**
       * Frames
       * Method 23
       * This method will switch To Frame based on WebElement(Name or ID)
       * @param driver
       * @param element
       */
      public void switchToFrame(WebDriver driver, WebElement element) {
    	  driver.switchTo().frame(element);
      }
      
      /**
       * Frames
       * Method 24
       * This method will switch the windows based on partial with title
       * @param driver
       * @param PartialWindowTitle
       */
      public void switchToWindow(WebDriver driver, String PartialWindowTitle) {
    	  //Step 1: Capture all the window ID's
    	  Set<String> allWindowIds = driver.getWindowHandles();//main//child
    	  
    	  //tep2: Navigate through each Window Id
    	  for(String windowID:allWindowIds) {		  
    		  //Step3: switch to each window and capture the title
    		  String actTitle = driver.switchTo().window(windowID).getTitle();
    		  
    		  //Step4: Compare the actual title with expected partial window Title
    		  if(actTitle.contains(PartialWindowTitle)) 
    		  {
    			  break;
    		  }
              
    	    }
    	  
      }	   
    	  
 
      /**
       * This method will take screenshot and store it in required folder
       * Frames
       * Method 25
       * @param driver
       * @param screenShotName
     * @throws IOException 
       */
      public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
    	  
    	  TakesScreenshot ts = (TakesScreenshot) driver;
    	  File src = ts.getScreenshotAs(OutputType.FILE);
    	  File dst = new File(".\\ScreenShot\\"+screenShotName+".png");
    	  //Step: open maven repository
    	  //search commons's IO -> click on APache Common IO's
    	  //write the below dependency in POM and update the project
    	  //<!-- https://mvnrepository.com/artifact/commons-io/commons-io --> <dependency> <groupId>commons-io</groupId> <artifactId>commons-io</artifactId> <version>2.13.0</version> </dependency> 
       
    	  Files.copy(src,dst);//
    	  
    	  // return the complete path of file, in this case it is screenshot 
    	  //this path is taken to attaching the screenshot to the report(extend report tool)
    	  return dst.getAbsolutePath();
      }
      
      
      

      
}
