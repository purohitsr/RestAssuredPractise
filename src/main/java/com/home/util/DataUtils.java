package com.home.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataUtils {
	
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	@DataProvider
	public  Object[][] getData(){
		Object[][] data=null;
		try{
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx"));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("landlords");
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			System.out.println("Total No of Rows are :"+rows+ " and total no of Cols are :"+cols);
			data=new Object[rows][cols];
			for(int row=0;row<rows;row++){
				Row currentRow = sheet.getRow(row+1);
				for(int col=0;col<cols;col++){
					data[row][col]=currentRow.getCell(col).toString();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}

}
