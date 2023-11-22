package DataDrvenTestingStart;

//******PROGRAM2***********/////

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
 */

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Open the document in Java Readable Format
		//Add throws exception
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: Create a workbook
		//.create(File File)
		//thows exception
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organisations");
		
		//Step4: Navigate to required row
		Row rw = sh.getRow(5);
		
		//Step5: Navigate to required Cell
		Cell c1 = rw.getCell(1);
		
		//Step6: Capture the value in the cell
		//getNumeric or get Boolean or String values
		String value = c1.getStringCellValue();
		System.out.println(value);
		
		
	}

}
