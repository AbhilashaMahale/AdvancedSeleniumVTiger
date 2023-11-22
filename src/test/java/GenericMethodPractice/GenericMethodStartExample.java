package GenericMethodPractice;


//////****PROGRAM10*******In Class////////

public class GenericMethodStartExample {

	public static void main(String[] args) {//caller function - values
		//test script
		int sum = add(20,30);//run only if called
        System.out.println(sum);
	}	
	
	public static int add(int a, int b) {
		int c = a+b;
		return c;
	}

}


