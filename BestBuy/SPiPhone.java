package BestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SPiPhone extends BaseBuy{
	@Test
	public void iPhone()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.log().all()
						.param("format", "json")
						.param("show", "name,regularPrice,salePrice")
						.param("apiKey",apiKey)
						.get("products(manufacturer=apple& search=mobile)");
		 System.out.println("Regular and selling price for iPhone11 Pro  ");
		 JsonPath jsonPath = response.jsonPath();
		 response.prettyPrint();
	}

}
