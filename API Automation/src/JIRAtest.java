import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class JIRAtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "http://localhost:8080/";
		
		//Code to Login and create session
		String sessionIDnumber = given().header("Content-Type","application/json").body("{ \"username\": \"bhandari.rashmi\", \"password\": \"quasar12\" }").when().post("rest/auth/1/session").then().extract().asString();
		JsonPath Js= new JsonPath(sessionIDnumber);
		String sessionID = Js.get("session.value");
		
		System.out.println(sessionID);
		
		//Add comment path param are added in curly braces they will be replaced by actual value during run time
		given().log().all().pathParams("Key", "BAU-25").header("Content-Type","application/json").header("Cookie","JSESSIONID="+sessionID+"").body("{\r\n"
				+ "    \"body\": \"Added comment from javatest1 today\" \r\n"
				+ "}").when().post("rest/api/2/issue/{Key}/comment").then().statusCode(201);
		
		
		
		System.out.println("completed");
		

	}

}
