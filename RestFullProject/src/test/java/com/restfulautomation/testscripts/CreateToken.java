package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CreateToken {
	
	static String token;
	@Parameters({"url"})
	@Test
	public void createToken(String url) {
		
		File requestPayload = new File("D:\\CreateTokenRequestPayload.json");
		
		token = given()
			.baseUri(url + "/auth")
			.header("Content-Type", "application/json")
			.body(requestPayload)
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("$", instanceOf(Object.class))
			.body("$", notNullValue())
			.extract().jsonPath().getString("token")
//			.log().all();
		;
		
	}

}
