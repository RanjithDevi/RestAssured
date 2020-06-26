package BestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StorePickupiPhone extends BaseBuy {
	@Test
	public void store()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.log().all()
						.param("format", "json")
						.param("show", "name,sku,name,stores.storeId,stores.name,stores.address")
						.param("apiKey",apiKey)
						.get("products(manufacturer=apple& search=mobile & inStorePickup=true)+stores(region=RI)");
						
		 System.out.println("Stores having store pick-up availability of iPhone 11 Pro in stores in RI region ");
		 JsonPath jsonPath = response.jsonPath();
		 response.prettyPrint();
	}
}
