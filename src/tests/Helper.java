package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Helper{
	
	public static String environmentURL;
	
	//Create a connection to the Movie DB
	//Return a movie response based on apiKey and movieID
	public static String getConnectionAndResponse(String movieID, String apiKey) throws Exception{
		String entireResponse = new String();

		try {
			URL url = new URL("https://api.themoviedb.org/3/movie/" + movieID + "?api_key=" + apiKey);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}

			Scanner scan = new Scanner(url.openStream());
			//String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();

			scan.close();
			
			conn.disconnect();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}		
		
		return entireResponse;
		
	}

	public static void titleValidation(String response, String title) throws Exception{
		JSONObject obj = new JSONObject(response);
		String originalTitle = obj.getString("original_title");
		assertEquals(title, originalTitle);
	}
	
	public static void responseValidation(String response, String expReleaseStatus) throws Exception{
		JSONObject obj = new JSONObject(response);
		String releaseStatus = obj.getString("status");
		System.out.println("status : " + releaseStatus);
		assertEquals(expReleaseStatus, releaseStatus);
	}	
}

//TODO
//Create Helper File
//Create helper classes
//Parameterize the helper classes
//Create 2-3 tests
//Create Git repo
/*
 * https://api.themoviedb.org/discover/movie?api_key=c38db9cf88e1a6d850d3268482e3ee28&primary_release_date.gte=2014-09-15
 * /discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22
 * https://api.themoviedb.org/3/movie/550?api_key=c38db9cf88e1a6d850d3268482e3ee28
 * https://api.themoviedb.org/3/movie/349?api_key=c38db9cf88e1a6d850d3268482e3ee28
 * BAD RESPONSE CODE
 * https://api.themoviedb.org/3/movie/34?api_key=c38db9cf88e1a6d850d3268482e3ee28
 * 
 * Spider-Man: Homecoming
 * https://api.themoviedb.org/3/movie/315635?api_key=c38db9cf88e1a6d850d3268482e3ee28
 * 
 * Lego Batman
 * 324849
 * 
 * Test Cases
 * What happens when an invalid url is passed?
 * Validate movie title
 * Rating a movie, TV Show, TV Episode
 * Validate an entire response
 * Validate release status
 * Validate release year
 * validate length of response
 * validate length of field
 * validate certain fields exist
 * Validate field not empty
 * Validate field is empty
 * Confirm unrelease movies against other criteria
 * Confirm required vs. not required fields
 * Validate field types
 * Test against low bandwidth
 * Test against high load
 * Valid image types
 * 
 * Classes
 * getConnectionAndResponse(String movieID, String apiKey)
 * GitHub repo: https://github.com/kevinpyles/moviedbapitesting.git
 * */
