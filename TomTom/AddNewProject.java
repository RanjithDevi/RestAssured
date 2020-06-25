package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddNewProject extends BaseClass{
	@Test
	public void Project()
	{
		 Response response=  RestAssured
					.given()
						
						.queryParam("key", apikey)
						.queryParam("adminKey","2uwknTR0KSyeQUSo28tKFb47N4MkWMfGiGN3LUl4hD4ARzcT")
						.contentType(ContentType.JSON)
						.body("{\r\n" + 
								"   \"name\": \"Oviyaa5 Project\"\r\n" + 
								" }")
					.post("projects/project");
		 JsonPath jsonPath = response.jsonPath();
		 projectid= jsonPath.get("id");
		 System.out.println("Project id  is : "+projectid);
		 response.prettyPrint();
	}
}
