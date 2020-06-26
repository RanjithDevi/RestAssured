package BestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductDetails extends BaseBuy{
	@Test
	public void proddetails()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.log().all()
						.param("format", "json")
						.param("show", "storeId,storeType,name,distance,address")
						.param("apiKey",apiKey)
						.param("pageSize", "1")
						.get("stores(area(02864,10))");
		 
		 JsonPath jsonPath = response.jsonPath();
		 response.prettyPrint();
		
		 

}
}
