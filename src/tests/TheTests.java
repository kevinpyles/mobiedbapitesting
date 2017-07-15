package tests;

import org.junit.BeforeClass;
import org.junit.Test;



public class TheTests {

	public static String apiKey;
	
	@BeforeClass
	public static void setup(){
		//Put your API Key in this variable
		apiKey = "c38db9cf88e1a6d850d3268482e3ee28";
	}
	
	@Test
	public void checkDBForTitle() throws Exception{
		
		
		String myResponse = Helper.getConnectionAndResponse("315635", apiKey);

		System.out.println("Response : "+ myResponse);
			
		Helper.titleValidation(myResponse, "Spider-Man: Homecoming");
	}
	
	@Test
	public void checkDBForReleaseStatus() throws Exception{
		
		String myResponse = Helper.getConnectionAndResponse("315635", apiKey);
		
		System.out.println("Response : " + myResponse);
		
		Helper.responseValidation(myResponse, "Released");
			
	}
	

}
