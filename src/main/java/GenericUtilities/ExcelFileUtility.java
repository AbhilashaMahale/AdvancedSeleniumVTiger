package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//////*******************************PROGRAM13****************************************Assigment of fri/06/10/2023////////
/*
 * After creating the PropertyFile Untility , now create ExcelFileUtility
 */

/**
 * This class consists of reusable methods related to Excel file
 * @author abhilasha
 *
 */

public class ExcelFileUtility {
	/**
	 * this Method will read data from excel file based on sheet name, row no
	 * and cell no and return the Caller
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheetname,int rowNum,int cellNum) throws IOException {
	
	FileInputStream fos = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fos);
	String value = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return value;
	
	}
	
	/**
	 * This method will read multiple data from excel and helps to provide data to data provider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis);
		Sheet sh1 = wb1.getSheet(sheetname);
		int lastRow = sh1.getLastRowNum();
		System.out.println(lastRow);
		int lastCell = sh1.getRow(0).getLastCellNum();
		System.out.println(lastCell);
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) 
		{
			for(int j=0;j<lastCell;j++) 
			{
				data[i][j] = sh1.getRow(i+1).getCell(j).getStringCellValue();
			}
			//why i+1 and j+1 becaise at i = 0 and j= 0 we have header name
			//which we dont want to print 
				
		}
		
		return data;
	}

}
