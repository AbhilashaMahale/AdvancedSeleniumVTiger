package GenericUtilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

///////////////////*******************PROGRAM 48 ********************//////////////////////
/**
 * 
 * @author abhilasha
 *
 */

public class RetryAnalyserImplementaion implements IRetryAnalyzer {

	
	int count = 0;
	int retrycount = 3; //based manual analysis, i have decided retry count to be 3
	//@Override
	public boolean retry(ITestResult result) {

		while(count<retrycount)
		{
			count++;
			return true;
		}
		//STOP execution or stop retrying the test script
		return false;
	}

}
