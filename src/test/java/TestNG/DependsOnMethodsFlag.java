package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsFlag {
	
	/*
	 * @Test(dependsOnMethods = "method name"
	 * Method gets skipped if dependent method is failed
	 * created method failed, hence modify is skipped
	 */
	
	@Test
	public void createCustomer() {
		System.out.println("created	the customer");//failed
		Assert.fail();
	}

    
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer() {
		System.out.println("modified the customer");//skip
	}
	
	 @Test(priority = 3)	
	public void deleteCustomer() {
		System.out.println("deleted the customer");//passed
	}

}
