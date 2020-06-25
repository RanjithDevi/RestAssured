package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RegisterKey extends BaseClass{
	@Test
	public void key()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.queryParam("key", apikey)
					.when()
						.body("{\r\n" + 
								"  \"secret\": \"secret_key\"\r\n" + 
								"}")
						.post("register");
		 JsonPath jsonPath = response.jsonPath();
		 adminKey=jsonPath.get("adminKey");
		 response.prettyPrint();
	}

}
