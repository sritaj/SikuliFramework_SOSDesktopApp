package profileCreation_testScripts;

import java.io.FileNotFoundException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to click the Add Profile Button*/

public class PCApp_TestCase_002_C01 {
	
	
	public static void main(String[] args) throws FindFailed, FileNotFoundException {
	
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		try {
				profile.addProfile();
				em.writeDataToExcel("PCApplication_TestCases", 5, 2, "PASS");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed");
			em.writeDataToExcel("PCApplication_TestCases", 5, 2, "FAIL");
		}
		
		pc.appQuit();
		
	}

}
