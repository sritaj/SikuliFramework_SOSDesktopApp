package dataManipulation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This class contains the Methods that is used to interact with the Excel Workbook */

public class ExcelManipulation {
	
	static String filepath ="F:\\GitHub\\SmartOLEDSwitch\\Test Suite\\UZ_Dilabs_SOS_Test Script_v_0.2.xlsx";
	
	/* This method is to set the data into Excel sheet */ 
	public void writeDataToExcel(String sheetName, int rowIndex, int cellIndex, String data) throws FileNotFoundException {
		
		try {
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row r = sh.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
