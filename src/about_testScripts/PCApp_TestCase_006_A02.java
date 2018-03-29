package about_testScripts;

import java.io.FileNotFoundException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Screens;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to navigate to Profile tab from About us tab*/

public class PCApp_TestCase_006_A02 {
	
	
	public static void main(String[] args) throws FindFailed, FileNotFoundException {
	
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Screens psr = new PC_App_Screens(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		try {
			psr.profileTab();
			em.writeDataToExcel("PCApplication_TestCases", 34, 2, "PASS");
		}catch (Exception e) {
			em.writeDataToExcel("PCApplication_TestCases", 34, 2, "FAIL");
			e.printStackTrace();
		}
	
		pc.appQuit();
		
	}


}
