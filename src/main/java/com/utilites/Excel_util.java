package com.utilites;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_util {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static void setExcelFile(String path, String sheetName) throws Exception  {
		FileInputStream fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		
	}
	public static String getCellData(int row, int col) {
		Cell cell=sheet.getRow(row).getCell(col);
		String cellData=cell.getStringCellValue();
		return cellData;
	}

}
