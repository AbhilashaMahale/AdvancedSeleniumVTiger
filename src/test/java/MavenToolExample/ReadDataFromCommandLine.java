package MavenToolExample;

import org.testng.annotations.Test;

/////////////////**********PROGRAM50*******//////////

//  this is done while doing MAVEN TOOL sessions
// Refer the notes of MAVEN done on 9th NOV 2023
// this code we can run directly in cmd


public class ReadDataFromCommandLine {
	
	@Test
	public void read() {
		
		
		System.out.println("HI");
		String UN = System.getProperty("username");
		String PWD = System.getProperty("password");
		
		System.out.println("HI");
		System.out.println(UN);
		System.out.println(PWD);
	}

}
