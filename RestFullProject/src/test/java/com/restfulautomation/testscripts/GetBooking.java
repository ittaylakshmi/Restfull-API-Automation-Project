package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetBooking {
	
	@Parameters({"url"})
	@Test
	
	public void getBooking(String url) {
		
		given()
			.baseUri(url + "/booking/" + CreateBooking.id)
		.when()
			.get()
		.then()
			.log().all()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("$", instanceOf(Object.class))
			.body("$", notNullValue())
			.log().all();
			
		;
	}

}
