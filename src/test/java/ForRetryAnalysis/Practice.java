package ForRetryAnalysis;

import org.testng.Assert;
import org.testng.annotations.Test;
///////////////////*******************PROGRAM 49********************//////////////////////
public class Practice {
	
	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementaion.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Hi");
	}

	@Test
	public void sample1()
	{
		System.out.println("Hello");
	}
}
