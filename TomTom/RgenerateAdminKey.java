package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RgenerateAdminKey extends BaseClass{
	@Test
	public void key()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
						.queryParam("key", apikey)
						.body("{\r\n" + 
								"   \"secret\": \"secret_key\"\r\n" + 
								" }")
						.post("regenerateKey");
		 response.prettyPrint();
		 JsonPath jsonPath = response.jsonPath();
		 regenid= jsonPath.get("adminKey");
		 System.out.println("Regenerated Admin Key is " +regenid);

}
}
