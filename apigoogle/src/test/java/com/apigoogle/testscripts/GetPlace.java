package com.apigoogle.testscripts;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetPlace {
	
	@Test
	public void getPlace() {
		
		given()
			.log().all()
			.baseUri("https://rahulshettyacademy.com")
			.header("Content-Type", "application/json")
			.queryParam("key", "qaclick123")
			.queryParam("place_id", AddPlace.place_id)
		.when()
			.get("/maps/api/place/get/json")
		.then()
			.log().all();
			System.out.println("Print PlaceID " + AddPlace.place_id);
		;
	}
}
