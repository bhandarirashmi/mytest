

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class oauthautomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//To get Access Token
		String Accesstokenresponse = given().queryParams("code","").queryParams("client_id","1234454").queryParams("client_secret","wewe").queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(Accesstokenresponse);
		String Accesstoken = js.getString("access_token");
		System.out.println(Accesstoken);
		
		
		//To use accesstoken and use information
		String reponse = given().queryParam("access_token",""+Accesstoken+"").when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(reponse);
		
	}

}
