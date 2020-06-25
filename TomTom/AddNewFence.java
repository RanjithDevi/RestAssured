package TomTom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddNewFence extends BaseClass{
	@Test(dependsOnMethods = {"TomTom.AddNewProject.Project"})
	public void Fence()
	{
		 Response response=  RestAssured
					.given()
						
						.queryParam("key", apikey)
						.queryParam("adminKey","2uwknTR0KSyeQUSo28tKFb47N4MkWMfGiGN3LUl4hD4ARzcT")
						.contentType(ContentType.JSON)
						.body("{\r\n" + 
								"  \"name\": \"Ranjitha1 Fence\",\r\n" + 
								"  \"type\": \"Feature\",\r\n" + 
								"  \"geometry\": {\r\n" + 
								"    \"radius\": 75,\r\n" + 
								"    \"type\": \"Point\",\r\n" + 
								"    \"shapeType\": \"Circle\",\r\n" + 
								"    \"coordinates\": [-67.137343, 45.137451]\r\n" + 
								"  },\r\n" + 
								"  \"properties\": {\r\n" + 
								"    \"maxSpeedKmh\": 70\r\n" + 
								"  }\r\n" + 
								"}")
						.post("projects/"+projectid+"/fence");
		 response.prettyPrint();
		 JsonPath jsonPath = response.jsonPath();
		 fenceid= jsonPath.get("id");
		 System.out.println("Fence id  created is :" +fenceid);
		 
	}

}
