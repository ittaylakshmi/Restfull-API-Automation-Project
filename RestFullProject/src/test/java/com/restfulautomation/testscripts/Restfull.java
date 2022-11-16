package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class Restfull {
	
		String token;
		int id;
		
		@Test
		
		public void getBookingIds() {
			given()
			.baseUri("https://restful-booker.herokuapp.com/booking")
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
	
		@Test
		public void createBooking() {
			
			File requestObj = new File("D:\\CreateRequestPayload.json");
			
			id = given()
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.header("Content-Type", "application/json")
				.body(requestObj)	
			.when()
				.post()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.body("$", instanceOf(Object.class))
				.body("$", notNullValue())
				.body("bookingid", instanceOf(Integer.class))
				.body("booking", instanceOf(Object.class))
				.body("booking.firstname", instanceOf(String.class))
				.body("booking.firstname", equalTo("Jim"))
				.body("booking.lastname", instanceOf(String.class))
				.body("booking.lastname", equalTo("Brown"))
				.body("booking.totalprice", instanceOf(Integer.class))
				.body("booking.totalprice", equalTo(111))
				.body("booking.depositpaid", instanceOf(boolean.class))		
				.body("booking.depositpaid", equalTo(true))
				.body("booking.bookingdates.checkin", instanceOf(String.class))
				.body("booking.bookingdates.checkin", equalTo("2018-01-01"))
				.body("booking.bookingdates.checkout", instanceOf(String.class))
				.body("booking.bookingdates.checkout", equalTo("2019-01-01"))
				.body("booking.additionalneeds", instanceOf(String.class))
				.body("booking.additionalneeds", equalTo("Breakfast"))
				.extract().jsonPath().getInt("bookingid")
//				.log().all();
			;
				System.out.println(id);	
		}
		
			
		@Test
		public void createToken() {
			
			File requestPayload = new File("D:\\CreateTokenRequestPayload.json");
			
			token = given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
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
//				.log().all();
			;
			
		}
	
		@Test
		
		public void getBooking() {
			
			given()
				.baseUri("https://restful-booker.herokuapp.com/booking/" + id)
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
	
		@Test
		public void updateBooking() {
			
			File updateReqPayload = new File("D:\\UpdateRequestPayload.json");
			
			given()
				.baseUri("https://restful-booker.herokuapp.com/booking/"+ id)
				.header("Content-Type", "application/json")
				.header("Accept", "application/json")
				.header("Cookie", "token=" + token)		
				.body(updateReqPayload)
			.when()
				.put()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().all();
				
			;
			
		}

		@Test
		public void partialUpdate() {
			
			File requestUpdtPayload = new File("D:\\PartialUpdtRequestPayload.json");
			
			given()
				.baseUri("https://restful-booker.herokuapp.com/booking/"+ id)
				.header("Content-Type", "application/json")
				.header("Accept", "application/json")
				.header("Cookie", "token=" +  token)
				.body(requestUpdtPayload)
			.when()
				.patch()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().all();
//				System.out.println(CreateToken.token);
//				System.out.println(CreateBooking.id);
			;
			
			
		}

	}
