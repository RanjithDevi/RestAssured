package UIPath;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Base {
	public static String id;
	public static String userid;
	public static String loannumber;
	@BeforeSuite
	
	public void setup()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api";
		 
	}

}
 