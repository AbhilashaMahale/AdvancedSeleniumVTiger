package DataDrvenTestingStart;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



//******PROGRAM3***********/////

public class WriteDataIntoPropertyFile {
	
	
public static void main(String[] args) throws Throwable {
		
		Properties p= new Properties();
		//new Properties();
		p.setProperty("username", "admin");
		p.setProperty("password", "admin");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Writedatapropertfile.properties",true);
		p.store(fos, "new file created");
		System.out.println("Property file created");

	}

	}

