package profileCreation_testScripts;

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

Test Case - Verify when user saves the profile the user is navigated to default screen of the Profile tab */

public class PCApp_TestCase_002_C06 {

public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		
		try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				grid.changeGridImage("13");
				if (profile.verifySaveActive()!=null) {
					profile.clickSaveActive();
					if (profile.verifySelectProfile()!=null) {
						System.out.println("User is re-directed to Profile TAB after save");
						em.writeDataToExcel("PCApplication_TestCases", 10, 2, "PASS");
			
					}else {
						System.err.println("User is not in the Profile Screen");
						em.writeDataToExcel("PCApplication_TestCases", 10, 2, "FAIL");
					}
				} else {
					System.err.println("Save button is not active");
				}
			}else {
				System.err.println("Profile is not available");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		pc.appQuit();
	}
}
