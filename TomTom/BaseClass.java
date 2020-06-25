package TomTom;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {
	public static String adminKey;
	public static String apikey = "RdsirXiugBO5E70tHLdKvu0fDa0jjMo9";
	public static String projectid;
	public static String projects; 
	public static String regenid; 
	public static String fenceid; 
	public static String key;
	public static String to;
	public static String maxResults;
	public static String pageNumber;
	@BeforeSuite
	
	public void setup()
	{
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/";
		 
	}

}
