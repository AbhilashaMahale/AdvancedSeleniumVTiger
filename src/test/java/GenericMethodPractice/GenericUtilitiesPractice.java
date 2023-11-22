package GenericMethodPractice;

import java.io.IOException;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PorpertyFileUtility;
import GenericUtilities.JavaUtility;

//////*******************************PROGRAM12****************************************In Class////////

//before this package GenericMthodsPractice is created in src/test/java and then 
//in src/main/java created a class PopertyFileUtility.java
//This will be later called in src/test/java GenericMthodsPractice package -> GenericUtilitiesPractice.java class



public class GenericUtilitiesPractice {
	
	
	public static void main(String[] args) throws IOException {
		
		//Step1: Calling the PorpertyFileUtility.java from src/main/java -> Generic Utilities  (from PROGRAM11)
		PorpertyFileUtility PUtillity = new PorpertyFileUtility();
		String p = PUtillity.readDataFromPropertyFile("BROWSER");
		System.out.println(p);
		
		//Step2: Calling the ExcelFileUtility.java from src/main/java -> Generic Utilities (from PROGRAM13)
		ExcelFileUtility PExceltillity = new ExcelFileUtility();
		String LASTNAME = PExceltillity.readDataFromExcelFile("Contacts",1,2);
		System.out.println(LASTNAME);
		String ORGNAME = PExceltillity.readDataFromExcelFile("Contacts",5,2);
		System.out.println(ORGNAME);
		
		//Step3: Calling getSystemDateInFormat -> JavaUtility.java created in  src/main/java -> Generic Utilities (from PROGRAM14)
		JavaUtility PJavaUtil = new JavaUtility();
	    String date = PJavaUtil.getSystemDateInFormat();
	    System.out.println(date);
	    
	    //Step3:Calling getRandomNumer -> JavaUtility.java created in  src/main/java -> Generic Utilities (from PROGRAM14)
	  	int ran = PJavaUtil.getRandomNumer();
	  	System.out.println(ran);
	    
	    
				
		
	}

}
