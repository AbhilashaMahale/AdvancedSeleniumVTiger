package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 * @author abhilasha
 *
 */

//////*******************************PROGRAM14****************************************In Class////////

//before this package GenericMthodsPractice is created in src/test/java and then 
//in src/main/java created a class PopertyFileUtility.java -> PROgram 11
//This will be later called in src/test/java GenericMthodsPractice package -> GenericUtilitiesPractice.java class ->  PROGRAm 12
//in src/main/java created a class ExcelFileUtility.java -> PROGRAM13 
// his will be later called in src/test/java GenericMthodsPractice package -> GenericUtilitiesPractice.java class ->  PROGRAm 12
//AFter this the below class is created in src/test/java which is program 14

public class JavaUtility {
    /**
     * This method will return the current system date in specified format
     */
	
	//Take Date() from java Util
	public String getSystemDateInFormat()
	{
		 Date d = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		 String currentdate = formatter.format(d);
		 return currentdate;
		 
		 
				 
	}

	/**
	 * this metod will generate a random number for every run
	 * @return
	 */
	public int getRandomNumer() {
		Random r = new Random();
		int value = r.nextInt(100);
		return value;
		
	}
}
