package UIPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApplyLoan extends Base{
	@Test
	public void loan()
	{
		Response response=  RestAssured
				.given()
					.contentType(ContentType.JSON)
					.log().all()
				.when()
					.body("{\r\n" + 
							"    \"email\": \"oviyaa10babu@gmail.com\",\r\n" + 
							"    \"amount\": 30000,\r\n" + 
							"    \"term\": 1,\r\n" + 
							"     \"income\": 40000,\r\n" + 
							"     \"age\": 37\r\n" + 
							"     }")
				.post("quotes/newquote");
		response.prettyPrint();
		 JsonPath jsonPath = response.jsonPath();
		 loannumber= jsonPath.get("quoteid");
		 System.out.println("Applied Loan number : "+loannumber);
	}
	

	 
}
