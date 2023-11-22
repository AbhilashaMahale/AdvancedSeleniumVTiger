
package GenericUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


//////////////////*****************PROGRAM 36 **************////////


/**
 * This class consists of basic configuration annotations of TESTNG
 * @author abhilasha
 *
 */
public class BaseClass {
	
	/* why these utilities are public??
	 * we can access them in child class
	 * if we can access them in child class no need to create object again
	 */
	
	//Create Object of all Utilities
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PorpertyFileUtility pUtil = new PorpertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver = null;
	
	/**
	 * This particular line is done for Listeners Concept
	 * PGM 44 -> src/main/java -> Generic Utilities-> ListenersImplamentaion.java
	 * PGM 46 -> src/test/java -? ForListeners -> CreateContactForListenersConceptForFail.java
	 */
	public static WebDriver sdriver;
	
	
	
	/**Step 1:
	 * Data Base Connection
	 */
	//@BeforeSuite(groups = "SmokeSuite")
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()//bs-beforsuite
	{
		//we do not have any database now so just do print statement
		System.out.println(".....database connection successful");
	}

	
	/**Step 2:
	 * Launch the Browser
	 * @throws IOException
	 */
	/*@BeforeClass(groups = "SmokeSuite")  -> instead of alwaysrun = true , we can use group name for smoke and regression testing */
	
	//@Parameters("browser") /*This is done specifically for cross browser to launch different type of browser for compatibility test,select from testng and not jcommand */
	
	
	//@BeforeTest /* THIS ONE IS DONE WHILE DOING DISTRIBUTEDPARALLEL and cross over EXECUTION, to launch multiple browsers of same type*/
	
	@BeforeClass(alwaysRun = true)  /*  ALWAYS USE THIS OPTION */
	
	public void bcConfig() throws IOException {
		
		/*Below two are the changes to be done while doing the cross browser*/
		//step 1:public void bcConfig(String BROWSER) throws IOException { //Pass String BROWSER as argument, as whatever the browser type we give in suite, it takes that browser(refer testngcrossbrowser.xml)
		//step 2:String BROWSER = pUtil.readDataFromPropertyFile("BROWSER"); //commented while doing cross browser,as we need not take browser info from property file(this file will have only one type of browser value so)
		
		/* browser info from property file*/
		String BROWSER = pUtil.readDataFromPropertyFile("BROWSER");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		
				if (BROWSER.equalsIgnoreCase("Chrome"))// true f
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("Browser launched");
				} 
				else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("Browser launched");
				} 
				else if (BROWSER.equalsIgnoreCase("Edge"))// f
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					System.out.println("Browser launched");
				} 
				else 
				{
					System.out.println("invalid Browser name");
				}
				
				/**
				 * This particular line is done for Listeners Concept
				 * PGM 44 -> src/main/java -> Generic Utilities-> ListenersImplamentaion.java
				 * PGM 46 -> src/test/java -? ForListeners -> CreateContactForListenersConceptForFail.java
				 */
				sdriver = driver; //used in listeners ONLY
				
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
		
	}
	
	/**
	 * Step3:
	 * Login to App
	 * @throws IOException 
	 */
	//@BeforeMethod(groups = "SmokeSuite")
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("-----Logged in to App Successfully---");
		
	}
	
	//@AfterMethod(groups = "SmokeSuite")
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("---Logged Out Successfully----");
	}
	
	//@AfterClass(groups = "SmokeSuite")
	//@AfterClass(alwaysRun = true)
	
	@AfterTest // THIS ONE IS DONE WHILE DOING DISTRIBUTEDPARALLEL and cross over EXECUTION, to launch multiple browsers
	public void acConfig() {
		
		driver.quit();
		System.out.println("---Browser Closed Successfully----");
		
	}
	
	
	//@AfterSuite(groups = "SmokeSuite")
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println(".....database dis-connectedl");
	}
	
	
}
