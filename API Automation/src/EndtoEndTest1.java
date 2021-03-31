import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resuableMethods.StringtoJason;

import static io.restassured.RestAssured.*;
import io.restassured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.springframework.util.Assert;

import ApiPayload.PayloadforAddPlace;



import org.testng.*;

import org.testng.asserts.*;




public class EndtoEndTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Validate ADD PLACE API
		
		//given - all input details 
		//when -submit the API ( resource)
		//then - validate the response
		
		
		// Testcase to ADD place then update place with new address and check if the place is updated using Get Place
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String addplaceresponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(PayloadforAddPlace.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(addplaceresponse);// response is extracted as string
		
		JsonPath js = new JsonPath(addplaceresponse);//JsonPath is used to parse the response. it takes String as input and parse the string to Json
		
		String placeId = js.getString("place_id");//Pass the path to the field you need to extract form json response
		
		System.out.println(placeId); 
		
		
		//Updateplace
		
		String newaddress = "70 Summer walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		//equalTO uses Hemcrest package
		//Getplace API
		String getplace = given().log().all().queryParams("key", "qaclick123","place_id",""+placeId+"").
when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//JsonPath js1= new JsonPath(getplace);//pass response which is string
		//JsonPath Js = StringtoJason(getplace);
		
		JsonPath Js2 = StringtoJason.stringtoJason(getplace);
		String placeid1 = Js2.getString("address");
		
	
		System.out.println(placeid1);
		if ((placeid1.equalsIgnoreCase(newaddress)))
		
		{
			System.out.println("address updated successfully");
			
		}
		else
		{
			System.out.println("address NOT updated successfully");
		}
		
		
		
	}

	private static ResponseAwareMatcher<Response> equalto(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	
	