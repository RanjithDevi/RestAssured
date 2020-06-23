package UIPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoanStatus extends Base{
	@Test(dependsOnMethods = {"UIPath.CreateLogin.Login", "UIPath.ApplyLoan.loan"})
	public void loanstat()
	{
		Response response=  RestAssured
				.given()
					.contentType(ContentType.JSON)
					.log().all()
					.header("Authorization", id)
					//.queryParam("quoteid", loannumber)
					.get("quotes/"+loannumber+"");
		response.prettyPrint();
		
	}
}
