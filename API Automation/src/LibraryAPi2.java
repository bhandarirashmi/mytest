

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ApiPayload.PayloadforAddPlace;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resuableMethods.StringtoJason;

//import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Paths;

public class LibraryAPi2 {
	//files.Readallbytes given by Java this is to open file. To open file provide the Path name using PAth. get and once you get the data from the file into Bytes convert it to String. To use this we need to add IO expection in method name
	@Test
	 public static void addbookdd() throws IOException 
	{
		
		RestAssured.baseURI = "http://216.10.245.166/Library";
		String response = given().headers("Content-Type","application/json").body(new String(java.nio.file.Files.readAllBytes(Paths.get("C:\\Users\\bhand\\Desktop\\API Automation\\postman data\\apidata.json")))).post("/Addbook.php").then().statusCode(200).extract().asString();
		
		JsonPath js3 = StringtoJason.stringtoJason(response);
		
		String result = js3.getString("Msg");
		
		System.out.println(result);
	}
}