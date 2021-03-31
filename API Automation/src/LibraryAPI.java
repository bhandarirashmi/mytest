
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ApiPayload.PayloadforAddPlace;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resuableMethods.StringtoJason;

//import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;

public class LibraryAPI {
	
	
	/* Payload coming from the function which is static 
	 * public static void addbook()
	{
		
		RestAssured.baseURI = "http://216.10.245.166/Library";
		String response = given().headers("Content-Type","application/json").body(PayloadforAddPlace.addbook()).post("/Addbook.php").then().statusCode(200).extract().asString();
		
		JsonPath js3 = StringtoJason.stringtoJason(response);
		
		String result = js3.getString("Msg");
		
		System.out.println(result);
	}
	*/
	
	//sending data to the function and you can make it dynamic ( Dynamic Jason payload build using external inputs)
	/*public static void addbook()
	
	{
		
		
		RestAssured.baseURI = "http://216.10.245.166/Library";
		
		 given().headers("Content-Type","application/json").body(PayloadforAddPlace.addbookparam("sded",342)).post("/Addbook.php").then().statusCode(200).extract().asString();
		
		/*JsonPath js3 = StringtoJason.stringtoJason(response);
		
		String result = js3.getString("Msg");
		
		System.out.println(result);}
		
		*/


	//payload coming from the function addbookparam pass it as parameter and make it dynamic. Parameterize the API test using Data provider
	
	@Test(dataProvider = "addbooks")// check the way data provider is written
	public static void addbook(String isbn, int aisle)//parameters for the dataprovider needs to be passed else fails
	{
		
		
		RestAssured.baseURI = "http://216.10.245.166/Library";
		
		 given().headers("Content-Type","application/json").body(PayloadforAddPlace.addbookparam(isbn,aisle)).post("/Addbook.php").then().statusCode(200).extract().asString();
		
		/*JsonPath js3 = StringtoJason.stringtoJason(response);
		
		String result = js3.getString("Msg");
		
		System.out.println(result);*/
	}
	
	
	@DataProvider(name="addbooks")//Check the spelling of DataProvider if not it gives error
	// Object is multidimensional array and had to create with same name
	public Object[][]  getdata()
			{
		//new object [][]= { array1, array 2, array 3}
		
		return new Object[][] {{"bsed",345},{"ewrd",567},{"sedf",678}};
		
			}
	
	
	
	

}
