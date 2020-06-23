package UIPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RegisterUser extends Base {
	@Test
	public void newuser()
	{
		Response response=  RestAssured
				.given()
					.contentType(ContentType.JSON)
					.log().all()
				.when()
					.body("{\r\n" + 
							"   \"firstName\": \"Ranjith\",\r\n" + 
							"   \"title\": \"mrs\",\r\n" + 
							"    \"lastName\": \"Devi\", \r\n" + 
							"   \"gender\": \"female\",\r\n" + 
							"   \"employmentStatus\": \"Unemployed\",\r\n" + 
							"   \"age\": \"05/28/82\",\r\n" + 
							"    \"maritalStatus\": \"Married\",\r\n" + 
							"    \"numberOfDependents\": 3,\r\n" + 
							"    \"username\": \"Ranju\",\r\n" + 
							"     \"email\": \"ranjubabu@gmail.com\",\r\n" + 
							"    \"password\": \"Babu_S*$*\",\r\n" + 
							"    \"type\": \"customer\"\r\n" + 
							"}")
				.post("users");
	}

}
