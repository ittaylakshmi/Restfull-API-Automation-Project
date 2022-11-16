package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class PartialUpdate {
		
	@Test
	public void partialUpdate() {
		
		File requestUpdtPayload = new File("D:\\PartialUpdtRequestPayload.json");
		
		given()
			.baseUri("https://restful-booker.herokuapp.com/booking/"+CreateBooking.id)
			.header("Content-Type", "application/json")
			.header("Accept", "application/json")
			.header("Cookie", "token=" + CreateToken.token)
			.body(requestUpdtPayload)
		.when()
			.patch()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
//			System.out.println(CreateToken.token);
//			System.out.println(CreateBooking.id);
		;
		
		
	}

}
