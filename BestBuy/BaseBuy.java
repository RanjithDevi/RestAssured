package BestBuy;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseBuy {
	public static String apiKey="qUh3qMK14GdwAs9bO59QRSCJ";
	public static String name;
	 
	@BeforeSuite
		
		public void setup()
		{
			RestAssured.baseURI="https://api.bestbuy.com/v1/";
		}

}
