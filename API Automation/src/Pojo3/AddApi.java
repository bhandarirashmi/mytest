package Pojo3; 


import ApiPayload.PayloadforAddPlace;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AddApi {
	
	@Test
	public static void AddPlace()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String addresponse=	given().log().all().header("Content-Type","application/json").queryParam("key","qaclick123").body(PayloadforAddPlace.AddPlace()).when().post("/maps/api/place/add/json").then().extract().asString();
		System.out.println(addresponse);
	}
}
