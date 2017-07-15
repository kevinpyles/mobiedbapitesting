/*
 * To execute the tests put your own apiKey in the "setup()" function. 
 * Right-click on title of test you want to run and select "Run as->JUnit Test"
 * You can also just click on the "Run" option for this file. 
 */

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
			 
/*
 * Validate movie title
 * Connect to DB
 * Get a Movie
 * Confirm title is expected
 * --see below checkDBForTitle()
 */
		 
/*
 * Rating a movie, TV show, TV Episode
 * Connect to DB
 * Add a movie rating
 * Check movie rating is added to DB
 */
		 
/*
 * Validate entire response matches previous response
 * Great for validating updates to API
 * Connect to DB
 * Get entire response 
 * compare to previous response
 */
		 
/*
 * Validate the Release status of movie
 * Connect to DB
 * Get a movie
 * Get release status
 * Compare release status to expected
 * --see below checkDBForReleaseStatus()
 */
		 
 /*
  * Validate the year of release for movie
  * Connect to DB
  * Get a movie
  * Get year of release
  * Compare year of release to expected
  */

 /*
  * Validate the length of fields for movie
  * Connect to DB
  * Get a movie
  * Get a specific field
  * Compare size to type of field size
  */

/*
 * What happens with invalid URL
 * Attempt to connect to the DB
 * Validate 404 message is sent
 */

/*
 * Validate fields exist
 * Get response from API
 * Check for individual or any fields
 */

/*
 * Field exists
 * Get a response from API
 * Valid field exists
 */
			 
/*
 * Field exists and is not empty
 * Get a response
 * Pull specific field
 * Make sure response is not empty
 */

/*
 * Check responses with empty fields
 * Do we need to respond with NULL, "", or some other value?
 * Test would depend on requirement
 * Get API response
 * Get a field
 * Check for valid empty status
 */
			 
/*
 * Check valid field types
 * If field is required to be a certain type or 
 * contain certain characters 
 * (or not contain certain characters)
 */
			 
/*
 * Test against low bandwidth
 * Various issues may arise such as:
 * Responses not returned (valid timeout?)
 * Partial returned values?
 * Call not received
 * No validation
 */
			 
/*
 * Test against high load
 * What can the server handle
 * What responses are given
 * What happens when server is overloaded
 * How does server recover
 * Do sessions time out?			 
 */
			 
/*
 * Valid vs. invalid apikeys
 * Pass in a valid apikey and make sure a valid response is returned
 * Pass in an invalid apikey and make sure no response is returned (Possible message other than 404?)
 * 
 */
			 
/*
 * Valid image types
 * Are extensions valid and are images found when uris are used? 		 
 */


			 
	
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
		
		Helper.releaseValidation(myResponse, "Released");
			
	}
	

}
