package profileEditing_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to change the image for a particular cell in the Pic Grid */

public class PCApp_TestCase_003_E02 {

public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				grid.changeGridImage("9");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "PASS");
				
			} else {
				System.err.println("Profile is not present");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "FAIL");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		pc.appQuit();
	}
}
