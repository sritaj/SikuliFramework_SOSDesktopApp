
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

Test Case - Verify user is able to select multiple images for the Pic Grid and save it */

public class PCApp_TestCase_002_C13 {

public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		Screen sr = new Screen();
		
		pc.appLaunch();
	
			try {
				
				profile.addProfile();
				sr.delayClick(500);
//				profile.setProfileName("Entertainment");
				grid.selectAllGridImage();
				
				if (profile.verifySaveActive()!=null) {
					profile.clickSaveActive();
					em.writeDataToExcel("PCApplication_TestCases", 17, 2, "PASS");
					System.out.println("Profile is saved");
				}else {
					em.writeDataToExcel("PCApplication_TestCases", 17, 2, "FAIL");
					System.err.println("Unable to save the profile");
					
				}
				
			}catch (Exception e) {
				pc.appForceQuit();
				e.printStackTrace();
			}
			pc.appQuit();
		
	}
}
