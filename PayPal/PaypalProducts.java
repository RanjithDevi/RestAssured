package PayPal;

 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PaypalProducts {
	//public static String sys_id;
	public static List<String> idLists = new ArrayList<String>();
	@DataProvider(name="Files")
	public String[] getFiles()
	{

		String[] files=new String[3];
		files[0]="C:\\Users\\91755\\eclipse-workspace\\RestAssured\\data\\products.json";
		files[1]="C:\\Users\\91755\\eclipse-workspace\\RestAssured\\data\\products1.json";
		files[2]="C:\\Users\\91755\\eclipse-workspace\\RestAssured\\data\\products2.json";
		return files;


}
	
@Test(dataProvider="Files")
void createProducts(String filename)
	{
		File jsonFile =new File(filename);
		RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products";
		RestAssured.authentication=RestAssured.oauth2("A21AAGSBVIUogN0-GvtrIczlBue870rKMHFPva8AdokmxBRk_qdE7q9A374CX1pEjxkiuHpDdZMetbrLVCg4NQJ2BJwzwvulg");
		Response response=RestAssured.given().log().all()
						            	  .contentType(ContentType.JSON)
						            	  .body(jsonFile)
						                  .post();
						              
		JsonPath jsonPath = response.jsonPath();
		int statuscode = response.getStatusCode();
		System.out.println("Status Code is "+statuscode);
		response.prettyPrint();
		String sys_id=jsonPath.get("id");
		idLists.add(sys_id);
		System.out.println("Ids " +idLists);
		
	}

}
