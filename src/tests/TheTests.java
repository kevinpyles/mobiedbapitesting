package tests;

import org.junit.Test;

public class TheTests {

	@Test
	public void firstCall(){
		System.out.println("Running my tests!");
	}
	
	@Test
	public void checkDBForTitle() throws Exception{
		
		String myResponse = Helper.getConnectionAndResponse("315635", "c38db9cf88e1a6d850d3268482e3ee28");

		System.out.println("Response : "+ myResponse);
			
		Helper.titleValidation(myResponse, "Spider-Man: Homecoming");
	}
	
	@Test
	public void checkDBForReleaseStatus() throws Exception{
		
		String myResponse = Helper.getConnectionAndResponse("315635", "c38db9cf88e1a6d850d3268482e3ee28");
		
		System.out.println("Response : " + myResponse);
		
		Helper.responseValidation(myResponse, "Released");
			
	}
	

}
