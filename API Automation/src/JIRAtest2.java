import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JIRAtest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "http://localhost:8080/";
		
		SessionFilter session1 = new SessionFilter();// session is object which can store session info and it can be used for subsequent API calls
		String sessionIDnumber = given().log().all().header("Content-Type","application/json").body("{ \"username\": \"bhandari.rashmi\", \"password\": \"quasar12\" }").filter(session1).when().post("rest/auth/1/session").then().extract().asString();
		
		//Add comment path param are added in curly braces they will be replaced by actual value during run time
		String responsecomment = given().log().all().pathParam("key","BAU-25").header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \"Added comment from code today n 24nightxyuyx\" \r\n"
				+ "}").filter(session1).when().post("rest/api/2/issue/{key}/comment").then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js3 = new JsonPath(responsecomment);
		int id = js3.getInt("id");//getID of the last added comment
		
		System.out.println(id);
//multipart method used to send attachments using restassured
		//given().pathParam("key","BAU-25").header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data").filter(session1).multiPart("file",new File("C:\\Resume\\sample.txt")).post("rest/api/2/issue/{key}/attachments").then().statusCode(200);
	
		//getissue
		String responseissue = given().pathParam("key", "BAU-25").queryParam("fields","comment").header("Content-Type","application/json").filter(session1).when().get("rest/api/2/issue/{key}").then().statusCode(200).extract().response().asString();
		
		JsonPath js4 = new JsonPath(responseissue);
		//int max = js4.getInt("fields.comment.maxResults");
		int max= js4.getInt("fields.comment.comments[].size()");//using size function to get size of array
		int responseid= js4.getInt("fields.comment.comments["+max+"-1].id");
		//check if the ID is equal to the last added ID if it matches thats the latest comment which was added
		if (responseid == id)
		{
			String comment = js4.getString("fields.comment.comments["+max+"-1].body");
			System.out.println(comment);
		}
		else
		{
	System.out.println("Id not matching");
		}
	}

}
