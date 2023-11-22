package TestNGDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//************************PROGRAM 34**********************///////

public class CreateMultipleContactsWithHardCodeValues {
	@Test(dataProvider = "getData")
	public void readData(String Name,String model,int qty,int price) {
		
		System.out.println(Name+"--"+model+"--"+qty+"--"+price);
		
	}
	
   @DataProvider
   public Object[][] getData(){
	   
	  Object[][] data = new Object[3][4];
	  //3 diff data sets with 4 details each
	  
	  data[0][0] = "Samsung";
	  data[0][1] = "A80";
	  data[0][2] = 12;
	  data[0][3] = 12000;
	  
	  data[1][0] = "Iphone";
	  data[1][1] = "S14";
	  data[1][2] = 16;
	  data[1][3] = 15000;
	  
	  
	  data[2][0] = "Vivo";
	  data[2][1] = "V21";
	  data[2][2] = 15;
	  data[2][3] = 10041;
	  
	  
	  return data;
	  
	  
			
   }
}
