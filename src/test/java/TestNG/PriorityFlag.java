package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityFlag {
	
	/*
	 * Priority for scripts
	 * Lower the value, higher the priority
	 */
	
	@Test(priority = 1)	
	public void createCustomer() {
		System.out.println("created	the customer");
		//Assert.fail();
	}

    
	@Test(priority = 2)		
	public void modifyCustomer() {
		System.out.println("modified the customer");
	}
	
	 @Test(priority = 3)	
	public void deleteCustomer() {
		System.out.println("deleted the customer");
	}
	 
///////////////////////////////////////////////////////////
	
	/*
	 * Accepts negative numbers for the priority
	 * 
	 */
/*@Test(priority = -1)	
		public void createCustomer() {
			System.out.println("created	the customer");
			//Assert.fail();
		}

	    
		@Test(priority = 0)		
		public void modifyCustomer() {
			System.out.println("modified the customer");
		}
		
		 @Test(priority = -3)	
		public void deleteCustomer() {
			System.out.println("deleted the customer");
		}*/
	 
//////////////////////////////////////////////////////
	
	/*
	 * IF THE PRIORITY IS SAME, then Take the ASCII Value
	 */
		 
		 /*
		 @Test(priority = 1)	
			public void createCustomer() {
				System.out.println("created	the customer");
				//Assert.fail();
			}

		    
			@Test(priority = 1)		
			public void modifyCustomer() {
				System.out.println("modified the customer");
			}
			
			 @Test(priority = 3)	
			public void deleteCustomer() {
				System.out.println("deleted the customer");
			}
			
			*/
	
	
///////////////////////////////
	
	/*
	 * IF NO PRIORITY GIVEN, the default value is zero
	 */
	
	/*
	 @Test(priority = 1)	
	public void createCustomer() {
		System.out.println("created	the customer");
		//Assert.fail();
	}

    
	@Test
	public void modifyCustomer() {
		System.out.println("modified the customer");
	}
	
	 @Test(priority = 3)	
	public void deleteCustomer() {
		System.out.println("deleted the customer");
	}
	 */
	 
/////////////////////////////////////////////////////////////
	/*
	 * if no priority given for two methods, runs with ASCII value 
	 * delete will run first here and then modify will run later
	 */
	/*
	 @Test(priority = 1)	
	public void createCustomer() {
		System.out.println("created	the customer");
		//Assert.fail();
	}

    
	@Test
	public void modifyCustomer() {
		System.out.println("modified the customer");
	}
	
	 @Test	
	public void deleteCustomer() {
		System.out.println("deleted the customer");
	}
	*/
	


	 
}
