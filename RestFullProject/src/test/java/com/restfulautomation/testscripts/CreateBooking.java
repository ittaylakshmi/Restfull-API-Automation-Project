package com.restfulautomation.testscripts;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.restfulautomation.helper.ExcelData;

import io.restassured.path.json.JsonPath;

public class CreateBooking {
	
//	String requestBody = "{\r\n"
//			+ "    \"firstname\" : \"Jim\",\r\n"
//			+ "    \"lastname\" : \"Brown\",\r\n"
//			+ "    \"totalprice\" : 111,\r\n"
//			+ "    \"depositpaid\" : true,\r\n"
//			+ "    \"bookingdates\" : {\r\n"
//			+ "        \"checkin\" : \"2018-01-01\",\r\n"
//			+ "        \"checkout\" : \"2019-01-01\"\r\n"
//			+ "    },\r\n"
//			+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
//			+ "}";
	
//	static int id;
	static String response;
//	static String url;
	
//	@Parameters ({"url"})
	@Test (dataProvider = "testData")
  public void createBooking(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkOut, String additionalNeeds) {
	
	//		File requestObj = new File("D:\\CreateRequestPayload.json");
		
		
		Map<String, Object> requestObj = new HashMap<String, Object>();
		requestObj.put("firstname", firstName);
		requestObj.put("lastname", lastName);
		requestObj.put("totalprice", Integer.parseInt(totalPrice));
		requestObj.put("depositpaid", Boolean.parseBoolean(depositPaid));
		Map<String, String> requestObj1 = new HashMap<String, String>();
		requestObj.put("bookingdates",requestObj1);
		requestObj1.put("checkin", checkIn);
		requestObj1.put("checkout", checkOut);
		requestObj.put("additionalneeds", additionalNeeds);
		
		
		response = given()
//			given() -- dont delete/dont touch this line
//			.baseUri("https://restful-booker.herokuapp.com/booking") -- this line used only for SYST testing Env.
			.baseUri("https://restful-booker.herokuapp.com/booking")
			.header("Content-Type", "application/json")
			.body(requestObj)	
//			.body(requestBody)
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
//			.body("$", instanceOf(Object.class))
//			.body("$", notNullValue())
//			.body("bookingid", instanceOf(Integer.class))
//			.body("booking", instanceOf(Object.class))
//			.body("booking.firstname", instanceOf(String.class))
//			.body("booking.firstname", equalTo(firstName))
//			.body("booking.lastname", instanceOf(String.class))
//			.body("booking.lastname", equalTo(lastName))
//			.body("booking.totalprice", instanceOf(Integer.class))
//			.body("booking.totalprice", equalTo(Integer.parseInt(totalPrice)))
//			.body("booking.depositpaid", instanceOf(boolean.class))		
//			.body("booking.depositpaid", equalTo(Boolean.parseBoolean(depositPaid)))
//			.body("booking.bookingdates.checkin", instanceOf(String.class))
//			.body("booking.bookingdates.checkin", equalTo(checkIn))
//			.body("booking.bookingdates.checkout", instanceOf(String.class))
//			.body("booking.bookingdates.checkout", equalTo(checkOut))
//			.body("booking.additionalneeds", instanceOf(String.class))
//			.body("booking.additionalneeds", equalTo(additionalNeeds))
//			.extract().jsonPath().getInt("bookingid")
			.extract().response().asString();
//			.log().all();
		
			JsonPath js=new JsonPath(response);
			
		;
			System.out.println(js);	
	}
	
	
	@DataProvider(name = "testData")
	public Object[][] testData () throws Exception {
	 	
		return ExcelData.excelData("D:\\CreateRequestPayload.xlsx", "sheet1");
		
//		File file = new File("D:\\CreateRequestPayload.xlsx");
//		
//		FileInputStream inputStream = new FileInputStream(file);
//		
//		Workbook workBook = WorkbookFactory.create(inputStream);
//		
//		Sheet sheet = workBook.getSheet("sheet1");
//		
//		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getPhysicalNumberOfCells()];
//		
//		for (int r=sheet.getFirstRowNum()+1; r<=sheet.getLastRowNum(); r++) {
//			for (int c=sheet.getRow(r).getFirstCellNum(); c<sheet.getRow(r).getLastCellNum(); c++) {
//				data[r-1][c] = sheet.getRow(r).getCell(c).toString();
//				}
//		}
//		
//		workBook.close();
//		return data;
	}
		
//		data[0][0] =  sheet.getRow(0).getCell(0).toString();
//		data[0][1] =  sheet.getRow(0).getCell(1).toString();
//		data[0][2] =  sheet.getRow(0).getCell(2).toString();
//		data[0][3] =  sheet.getRow(0).getCell(3).toString();
//		data[0][4] =  sheet.getRow(0).getCell(4).toString();
//		data[0][5] =  sheet.getRow(0).getCell(5).toString();
//		data[0][6] =  sheet.getRow(0).getCell(6).toString();
//		
//		data[1][0] =  sheet.getRow(1).getCell(0).toString();
//		data[1][1] =  sheet.getRow(1).getCell(1).toString();
//		data[1][2] =  sheet.getRow(1).getCell(2).toString();
//		data[1][3] =  sheet.getRow(1).getCell(3).toString();
//		data[1][4] =  sheet.getRow(1).getCell(4).toString();
//		data[1][5] =  sheet.getRow(1).getCell(5).toString();
//		data[1][6] =  sheet.getRow(1).getCell(6).toString();
//		
//		Object[][] data = {
//				{"https://restful-booker.herokuapp.com","Jim1","Brown1","111","true","2018--01","2019-01-01","Breakfast"}
//				{"https://restful-booker.herokuapp.com","Jim2","Brown2","222","true","2018-01-01","2019-01-01","Breakfast"},
//				{"https://restful-booker.herokuapp.com","Jim3","Brown3","333","true","2018-01-01","2019-01-01","Breakfast"}
//	}	
	
}
