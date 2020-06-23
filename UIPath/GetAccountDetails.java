package UIPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAccountDetails extends Base{
	@Test (dependsOnMethods = {"UIPath.CreateLogin.Login"})
	public void getAccountDetails()
	{
		Response response=  RestAssured
				.given()
					.contentType(ContentType.JSON)
				.log().all()
					.header("Authorization",id)
				.queryParam("filter[where][userId]",userid)
					.get("accounts");
		response.prettyPrint();
	}
}