package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of reusable methods related to proeoprty file
 * @author abhilasha
 *
 */

//////*******************************PROGRAM11****************************************In Class////////

//before this package GenericMthodsPractice is created in src/test/java and then 
// in src/main/java created a class PopertyFileUtility.java
//This will be later called in src/test/java GenericMthodsPractice package -> GenericUtilitiesPractice.java class

public class PorpertyFileUtility {


//will go for non static methods instead of non static methos
	//memory allocation will happen only if u create an object, which takes a little less memory 
	//but if u make it as static,memory allocation will happen
	
	/**
	 * This method will read data from property file for the key provided by caller and return value to the caller
	 * @param Key
	 * @return value
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}

}
