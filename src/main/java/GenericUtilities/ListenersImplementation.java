package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



////////////////////////********************PROGRAM44************////////////////////////////////////

/**** REFER ALL THE COMMENTS BELOW , VERY IMPORTANT TO UNDERSTAND**/
/**
 * This class provides implementation to ITestListener Interface of TEstNG
 * @author abhilasha
 *
 */

//double click on the class name "ListenersImplementation"
//right click copy qualified name, the it copies as  like this"GenericUtilities.ListenersImplementation"
//  this qualified name means -> it will have package name along with class name
// go to the script now -> createContactTests.java
//type this below mentioned line  just above the class name in the script ->
// @Listeners(GenericUtilities.ListenersImplementation.class)


public class ListenersImplementation implements ITestListener {
	
	//EXTENT REPORT:
	  ExtentReports report;	
	  ExtentTest test;
	
	//never write method of interface
	//right click -> go to  source , -> click on override/implement methods , click on ItestListener interface

	
	//STEP3:one @Test started
	//Every Test annotation will have method name
	//method name should be test case name or test case ID
	//Capture that method name to see which script is executing
	//do that using ItestResult
	//currently running script information will be in the result argument ITestresult interface
	@Override
	public void onTestStart(ITestResult result) {

		//ITestListener.super.onTestStart(result);//delete all of this
		
		//current method name or name of the test annotation method or the test script//
		//observe: its not the class , its the method
		String methodName = result.getMethod().getMethodName();
		
		System.out.println("====Test Exceution Started=====");
		
		//EXTENT REPORT:create Test which is going to return the extent test object
		//EXTENT REPORT:Indication to the extent report that test execution started
		
		 test = report.createTest(methodName);
		
	}

	
	
	//Step 4:
	@Override
	public void onTestSuccess(ITestResult result) {
		//we can get the method name here also
		//this methodName can be made global or not?
		//Answer is : through result only we are capturing the method name
		//this result is purely run time information
		//whenever we run the program, which test annotation is running, only that is recorded
		//if there is not test annotation running, it will not hold any value
		//hence it can NOT be made as global
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"====Test PASS=====");
		
		
		
		//EXTENT REPORT:add log status here
		test.log(Status.PASS,methodName+"====Test PASS=====");
	}

	
	
	
	@Override
	public void onTestFailure(ITestResult result) {


		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"====Test FAIL=====");
		
		/* Below Steps are done While there is Test case failed 
		 * For this PGM 46 is written in src/test/java
		 * Refer Page pf 2nd Nov,2023 for detailed explaintion 
		 */
		//step1: to capture the exception in the form of string
		System.out.println(result.getThrowable());		
		
		
		// EXTENT REPORT: these two below lines:
		test.log(Status.FAIL, methodName+"====Test FAIL=====");
		test.log(Status.INFO, result.getThrowable()); 
		
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		
		String screenshotName = methodName+jUtil.getSystemDateInFormat();
		
		try
		{
			//this line while testnNG report generation and capture the screenshot seperately
			//wUtil.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			/* EXTENT REPORT: This Line is Added while creating ExtentReport */
			String path = wUtil.captureScreenShot(BaseClass.sdriver, screenshotName);			
			test.addScreenCaptureFromPath(path);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public void onTestSkipped(ITestResult result) {


		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"====Test SKIP=====");
		
		//EXTENT REPORT: Line added
		test.log(Status.SKIP, methodName+"====Test SKIP=====");
		test.log(Status.INFO, result.getThrowable()); 
		
		
		
	}

	
	
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	
	
	//STEP 1:	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//EXTENT REPORT: Extent repoprt Configuration
		
		System.out.println("====Suite Execution Started=====");
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExterntReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Excution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("QCO-SOEAJD-M%-Excution report");
		
		//EXTENT REPORT: Extent Report Class
		
	   report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Edge");//For system related configuration
		report.setSystemInfo("Base PlatForm", "Windows Family");
		report.setSystemInfo("Base Env", "Testng");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Abhilasha");
	}

	
	
	
	//STEP2:	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("====Suite Exceution Finished=====");
		
		//EXTENT REPORT:indication for extent reports that execution is completed and we can generate the report now
		report.flush();
	}
	
	
	
	
	

}
