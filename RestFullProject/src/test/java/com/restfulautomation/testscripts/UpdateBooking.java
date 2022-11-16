package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class UpdateBooking {
	
	
	@Test
	public void updateBooking() {
		
		File updateReqPayload = new File("D:\\UpdateRequestPayload.json");
		
		given()
			.baseUri("https://restful-booker.herokuapp.com/booking/"+CreateBooking.id)
			.header("Content-Type", "application/json")
			.header("Accept", "application/json")
			.header("Cookie", "token=" + CreateToken.token)		
			.body(updateReqPayload)
		.when()
			.put()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
			
		;
		
	}

}
