package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetBookingIds {
	@Parameters({"url"})
	//	public void getBookingIds() {
	@Test
	
	public void getBookingIds(String url) {
		given()
		.baseUri(url + "/booking")
	.when()
		.get()
	.then()
		.log().all()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("$", instanceOf(Object.class))
		.body("$", notNullValue())
	;
		
	}

}
