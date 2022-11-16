package com.restfulautomation.helper;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	
	public static Object[][] excelData (String fileName, String sheetName) throws Exception {
		
		File file = new File(fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workBook = WorkbookFactory.create(inputStream);
		
		Sheet sheet = workBook.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getPhysicalNumberOfCells()];
		
		for (int r=sheet.getFirstRowNum()+1; r<=sheet.getLastRowNum(); r++) {
			for (int c=sheet.getRow(r).getFirstCellNum(); c<sheet.getRow(r).getLastCellNum(); c++) {
				data[r-1][c] = sheet.getRow(r).getCell(c).toString();
				}
		}
		
		workBook.close();
		return data;
	}
}
