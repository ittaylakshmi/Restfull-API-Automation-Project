package com.payload.files;

import com.apigoogle.testscripts.AddPlace;

public class UpdatePlaceFile {
	
	public static String updatePlaceFile() {
		return "{\r\n"
				+ "\"place_id\":\""+AddPlace.placeid+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
}
