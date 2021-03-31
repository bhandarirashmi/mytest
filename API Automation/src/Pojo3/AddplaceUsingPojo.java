package Pojo3;


import ApiPayload.PayloadforAddPlace;



import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddplaceUsingPojo {
	//Pass body using POJO Class - serialisation - Convert Java Object into JSon)
	    @Test
		public static void AddPlace()
		{
			AddPlacePOJOclass p = new AddPlacePOJOclass();
			p.setAccuracy(50);
			p.setAddress("811 portsmith couedrt");
			p.setLanguage("german");
			p.setName("super");
	    	p.setPhone_number("(+91) 983 893 3937");
	    	p.setWebsite("www.facebook.com");
	    	
	    	
	    	List<String> types= new ArrayList<String>();//Declare a List of String variable
	    	types.add("Shoe");
	    	types.add("fresh");
	        p.setTypes(types);
	        
	        locationPojoClass l= new locationPojoClass();//Declare a object for class and set the Variable for the Object
	      l.setLat(34.23);
	      l.setLng(45.12);
	    	
	      p.setLocation(l);//pass the object to the method
	    	/* without using specbuilder
	    	 * RestAssured.baseURI = "https://rahulshettyacademy.com";
		    String addresponse=	given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123").body(p).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
			System.out.println(addresponse);
			
			*/
	      
	     
	      //Second way of doing it using specbuilder
	      //REquest Specbuilder
	      RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();//.build has to be added at end
	      //Response Specbuilder
	      ResponseSpecification Resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	      
	      String addresponse=	given().spec(req).body(p).when().post("/maps/api/place/add/json").then().spec(Resp).extract().asString();
			System.out.println(addresponse);
	      
	      
		}
	


}
