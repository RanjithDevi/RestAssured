package Covid19;


import org.apache.commons.collections4.iterators.EntrySetMapIterator;
 
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CovidDatFlow {

	@Test
	public   void getresults() {
		RestAssured.baseURI="https://covid-19.dataflowkit.com/v1";
		Response response=RestAssured.given().log().all().get();
		JsonPath jsonPath = response.jsonPath();
		int statuscode = response.getStatusCode();
		response.prettyPrint();
		
		
		 Map<Integer,String> mapcases= new TreeMap<Integer,String>(Collections.reverseOrder());;
		 List<String> country =jsonPath.getList("Country_text");
		 List<String> newcase =jsonPath.getList("\"New Cases_text\"");
		 List<String> deathcase =jsonPath.getList("\"New Deaths_text\"");
		 System.out.println("India Details");
		 for (int a=0; a< country.size()-1 ; a++)
		 {
			 if (country.get(a).equalsIgnoreCase("india"))
			 {
			  RestAssured.baseURI="https://covid-19.dataflowkit.com/v1/india";
			 Response response1=RestAssured.given().log().all().get();
			 JsonPath jsonPath1 = response1.jsonPath();
	      	 response1.prettyPrint();
	
			 }
		 }
		 for (int k=0; k< newcase.size() ; k++)
		 {
			  if (newcase.get(k)!="" && (newcase.get(k)!= null) && !country.get(k).equalsIgnoreCase("world"))
			  {
				  String caserep=newcase.get(k).replaceAll("\\D","");
				  int casecount=Integer.parseInt(caserep);
				  mapcases.put(casecount,country.get(k));
				  
			  }
			
		 }	 
		 System.out.println("Countries with new cases");
		 int c=0;
			for (Entry<Integer,String> eachentry :mapcases.entrySet()) {
				if (c<5)
				{
					System.out.println(eachentry.getKey() +" --> " +eachentry.getValue());
					c++;
				}
		 }
		System.out.println("Countries with lowest new death cases");
		Map<Integer,String> mapdeath= new TreeMap<Integer,String>(); 
		 for (int p =0; p< deathcase.size() ; p++)
		 {
			  if (deathcase.get(p)!="" && (deathcase.get(p)!= null) && !country.get(p).equalsIgnoreCase("world"))
			  {
				  String casedeath=deathcase.get(p).replaceAll("\\D","");
				  int deathcount=Integer.parseInt(casedeath);
				  mapdeath.put(deathcount,country.get(p));
				  
			  }
		 }	 
		 
		 int d=0;
			for (Entry<Integer,String> eachentry1 :mapdeath.entrySet()) {
				if (d<5)
				{
					System.out.println(eachentry1.getKey() +" --> " +eachentry1.getValue());
					d++;
				}
			}

		 int status=response.getStatusCode();
		 if (status ==200)
			 System.out.println("HTTP Status code is 200 and is correct");
		 else
			 System.out.println("HTTP Status code is not 200 and is not correct");
		
		long time =response.getTime();
		System.out.println("Response time is "+time);
		if (time <600)
		 	System.out.println("Response time is less than 600ms");
		else
			System.out.println("Response time is not less than 600ms");
		String type=response.getContentType();
		System.out.println("Content type is " +type);
		
	

	}

}
