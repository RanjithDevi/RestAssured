package UIPath;

import org.testng.annotations.Test;

import JIRA.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateLogin extends Base{
	//public static String id;
	@Test
	public void Login()
	{
		 Response response=  RestAssured
					.given()
						.contentType(ContentType.JSON)
					.when()
						.body("{\r\n" + 
								"    \"username\": \"Ranji\", \r\n" + 
								"    \"password\": \"Babu_S*$*\"\r\n" + 
								"}")
					.post("users/login");
		 JsonPath jsonPath = response.jsonPath();
		 id= jsonPath.get("id");
		 userid=jsonPath.getString("userId");
		 System.out.println("Authorization id  created is :" +id);
		 System.out.println("Userid created is " +userid);
		 
		 response.prettyPrint();
		 
	}

}
