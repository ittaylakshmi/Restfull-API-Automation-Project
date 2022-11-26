package com.apigoogle.testscripts;

import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;

import com.payload.files.UpdatePlaceFile;

public class UpdatePlace {
	
	@Test
	public void updataPlace() {
		
//		String Placeid = AddPlace.place_id;
		System.out.println(AddPlace.place_id);
		
//		File request=new File("E:\\googleapi\\UpdatePlace.json");
		
		given()
			.log().all()
			.baseUri("https://rahulshettyacademy.com")
			.headers("Content-Type", "application/json")
			.queryParams("Key", "qaclick123")
			.body(UpdatePlaceFile.updatePlaceFile())
		.when()
			.put("/maps/api/place/update/json")
		.then()
			.log().all()
		;
	}
}
