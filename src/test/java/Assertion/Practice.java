package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice {
	@Test
	public void Practice() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(2, 1);
		System.out.println("Step 3");
	}

	@Test
	public void practice1() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		
		sa.assertEquals(true, false);//f
		System.out.println("Step 2");
		
		sa.assertEquals("B", "A");//f
		
		Assert.assertTrue(false);//f
		
		System.out.println("Step 3");
		
		sa.assertAll();//failure logged
	}
}
