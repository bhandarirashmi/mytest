import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class jiratest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "http://localhost:8080/";
		
		//Code to Login and create session
		SessionFilter session = new SessionFilter();// session is object which can store session info and it can be used for subsequent API calls
		String sessionIDnumber = given().log().all().header("Content-Type","application/json").body("{ \"username\": \"bhandari.rashmi\", \"password\": \"quasar12\" }").filter(session).when().post("rest/auth/1/session").then().extract().asString();
		
		//Add comment path param are added in curly braces they will be replaced by actual value during run time
		given().log().all().pathParam("key","BAU-25").header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \"Added comment from code today\" \r\n"
				+ "}").filter(session).when().post("rest/api/2/issue/{key}/comment").then().assertThat().statusCode(201);
		
		System.out.println("completed");


	}

}
