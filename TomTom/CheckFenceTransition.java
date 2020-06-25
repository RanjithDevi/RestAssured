package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.containsString;

public class CheckFenceTransition extends BaseClass{
   @Test(dependsOnMethods = {"TomTom.AddNewFence.Fence"})
	public void Transitions()
	{
	 ValidatableResponse response=  RestAssured
					.given()
					.contentType(ContentType.JSON)
					.queryParam("key", apikey)
					.queryParam("from", "2020-06-24T01:00:00")
					.queryParam("to","2020-06-24T23:00:00")
					.queryParam("maxResults","70")
					.queryParam("pageNumber","5")
					.contentType(ContentType.JSON)
					.get("transitions/fences/"+fenceid+"")
					.then()
					.statusCode(200)
					.body(containsString(fenceid));
	}
							
}
