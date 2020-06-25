package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.containsString;

public class GetProjectList extends BaseClass {
	@Test(dependsOnMethods = {"TomTom.AddNewProject.Project"})
	public void AddProject()
	{
		 ValidatableResponse response=  RestAssured
					.given()
					.log().all()
					.queryParam("key", apikey)
					.contentType(ContentType.JSON)
					.get("projects")
					.then()
					.statusCode(200)
					.body(containsString(projectid));
		 
	 
	}
 
	}
