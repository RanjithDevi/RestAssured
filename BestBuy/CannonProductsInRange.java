package BestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CannonProductsInRange extends BaseBuy {
	@Test
	public void cannon()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.log().all()
						.param("format", "json")
						.param("show", "sku,name,salePrice")
						.param("apiKey",apiKey)
						.get("products(manufacturer=canon & salePrice<1500 & salePrice >1000)");
		 System.out.println("The cannon products with sale price from 1000 to 1500 are ");
		 JsonPath jsonPath = response.jsonPath();
		 response.prettyPrint();
	}

}
