package com.apigoogle.testscripts;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DeletePlace {
	
	@Test
	public void deletePlace() {
		
		String request = "{\r\n"
				+ "    \"place_id\":\""+AddPlace.placeid+"\"\r\n"
				+ "}\r\n"
				+ "";
		given()
			.log().all()
			.baseUri("https://rahulshettyacademy.com")
			.header("key", "qaclick123")
			.body(request)
		.when()
			.delete("/maps/api/place/delete/json")
		.then()
		;		
	}

}
