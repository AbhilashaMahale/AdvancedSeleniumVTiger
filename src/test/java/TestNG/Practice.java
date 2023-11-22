package TestNG;

import org.testng.annotations.Test;

public class Practice {
	
	@Test()
	public void createCustomer() {
		System.out.println("created	the customer");
		//Assert.fail();
	}

    
	@Test()	
	public void modifyCustomer() {
		System.out.println("modified the customer");
	}
	
	 @Test()	
	public void deleteCustomer() {
		System.out.println("deleted the customer");
	}

}
