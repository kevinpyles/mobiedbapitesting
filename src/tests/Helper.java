package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.json.JSONArray;
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

	@Test
	public void aptTesting() throws Exception {
		try {
			URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221;");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}

			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();

			System.out.println("Response : "+entireResponse);

			scan.close();

			JSONObject obj = new JSONObject(entireResponse);
			String responseCode = obj.getString("status");
			System.out.println("status : " + responseCode);

			JSONArray arr = obj.getJSONArray("results");
			for (int i = 0; i < arr.length(); i++) {
				String placeid = arr.getJSONObject(i).getString("place_id");
				System.out.println("Place id : " + placeid);
				String formatAddress = arr.getJSONObject(i).getString(
						"formatted_address");
				System.out.println("Address : " + formatAddress);

//validating Address as per the requirement
				if(formatAddress.equalsIgnoreCase("Chicago, IL, USA")){
					System.out.println("Address is as Expected");
				}else{
					System.out.println("Address is not as Expected");
				}
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	/*
	@Test
	public void movieDBAPICall() throws Exception {
		try {
			//URL url = new URL("https://api.themoviedb.org/3/movie/315635?api_key=c38db9cf88e1a6d850d3268482e3ee28;");
			URL url = new URL("https://api.themoviedb.org/3/movie/324849?api_key=c38db9cf88e1a6d850d3268482e3ee28;");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}

			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();

			System.out.println("Response : "+entireResponse);

			scan.close();

			JSONObject obj = new JSONObject(entireResponse);
			String releaseStatus = obj.getString("status");
			System.out.println("status : " + releaseStatus);
			
			String originalTitle = obj.getString("original_title");
			System.out.println("Original Title : " + originalTitle);

			assertEquals("Spider-Man: Homecoming", originalTitle );
			
			if(originalTitle.equalsIgnoreCase("Spider-Man: Homecoming")){
				System.out.println("Title matches");
			}else{
				System.out.println("Title does not match");
			}
			
			/*
			JSONArray arr = obj.getJSONArray("results");
			for (int i = 0; i < arr.length(); i++) {
				String originalTitle = arr.getJSONObject(i).getString("original_title");
				System.out.println("Original Title : " + originalTitle);
				String overview = arr.getJSONObject(i).getString(
						"overview");
				System.out.println("Overview : " + overview);

//validating Address as per the requirement
				if(originalTitle.equalsIgnoreCase("Murder She Said")){
					System.out.println("Title does not match");
				}else{
					System.out.println("Title does not match");
				}
			}
			

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	*/
	
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
 * */
