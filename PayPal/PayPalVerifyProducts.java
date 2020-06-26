package PayPal;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PayPalVerifyProducts{
	
@Test(dependsOnMethods= {"PayPal.PaypalProducts.createProducts"})
public void verifyProducts()
{
	RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products";
	RestAssured.authentication=RestAssured.oauth2("A21AAGSBVIUogN0-GvtrIczlBue870rKMHFPva8AdokmxBRk_qdE7q9A374CX1pEjxkiuHpDdZMetbrLVCg4NQJ2BJwzwvulg");
	  Response response=RestAssured
		         .given()
		         .param("page_size", "100")
		         .get();
		  
		  JsonPath jsonResponse=response.jsonPath();
		 
		  response.prettyPrint();
		  
		 List<String> products = jsonResponse.get("products.id");
		 int len = products.size();
		 System.out.println("Products");
		
		  for (int i=0;i<=PaypalProducts.idLists.size()-1;i++)
		  {
			  for (int j =0;j<=len-1;j++)
			  {
			      if (PaypalProducts.idLists.get(i).equalsIgnoreCase(products.get(j)))
						System.out.println("The created product " +PaypalProducts.idLists.get(i)+ " is available in the list");
				 
			  }
		  }
	
}


}




