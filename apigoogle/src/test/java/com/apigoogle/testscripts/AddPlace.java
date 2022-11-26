package com.apigoogle.testscripts;

import static io.restassured.RestAssured.*;
import java.io.File;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class AddPlace {

	public static String response;
	public static String place_id;
	
	@Test
	public void addPlace() {
		
		File file=new File("E:\\googleapi\\AddPlaceReqPayLoad.json");
		
		response = given()
			.log().all()
			.baseUri("https://rahulshettyacademy.com")
			.headers("Content-Type","application/json")
			.queryParam("key", "qaclick123")
			.body(file)			
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.log().all()
			.statusCode(200)
			.body("$", instanceOf(Object.class))
			.body("$", notNullValue())
			
			.extract().response().asString();
//			.extract().jsonPath().getString("place_id");
		
			JsonPath js=new JsonPath(response);
			String place_id = js.getString("place_id");
			System.out.println("Place ID is - " + place_id);
			
//			return place_id;
	}
}
