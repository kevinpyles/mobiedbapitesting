//This is the helper file for the test. 

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

	//Pass in an API response, and title and the test will check if the expected title is found in the response. 
	public static void titleValidation(String response, String title) throws Exception{
		JSONObject obj = new JSONObject(response);
		String originalTitle = obj.getString("original_title");
		assertEquals(title, originalTitle);
	}
	
	//Pass in an API response, and expected Release Status and test will check if that release status is correct for the movie.
	public static void releaseValidation(String response, String expReleaseStatus) throws Exception{
		JSONObject obj = new JSONObject(response);
		String releaseStatus = obj.getString("status");
		System.out.println("status : " + releaseStatus);
		assertEquals(expReleaseStatus, releaseStatus);
	}	
}
