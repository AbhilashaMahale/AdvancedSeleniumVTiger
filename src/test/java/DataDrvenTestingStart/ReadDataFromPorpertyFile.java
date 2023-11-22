package DataDrvenTestingStart;

//******PROGRAM1***********/////

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPorpertyFile {
	
	public static void main(String[] args) throws IOException {
	//Step 1:Open the Document in Java Readable Format
    //path of commondata.properties - no need to give the full path, instead .\\ do this and enter the rest of path
		//INputexception
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//Step2: Create an object properties class from Java.util
	Properties p = new Properties();
	
	//Step 3: Load the input Stream into properties
	//IO exception
	p.load(fis);
	
	//Step 4: Provide the kesy to read the values
	String value = p.getProperty("browser");
	System.out.println(value);
	
	String value1 = p.getProperty("url");
	System.out.println(value1);
	
	String value2 = p.getProperty("username");
	System.out.println(value2);
	
	String value3 = p.getProperty("password");
	System.out.println(value3);
	
	
	
	

	}
}
