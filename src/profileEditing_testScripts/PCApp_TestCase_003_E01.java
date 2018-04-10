package profileEditing_testScripts;

import static org.testng.Assert.assertFalse;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to change the Profile Name*/

public class PCApp_TestCase_003_E01 {
	
	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
        try {
			
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				try {
					profile.setProfileName("Profile1");
					em.writeDataToExcel("PCApplication_TestCases", 20, 2, "PASS");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else {
				assertFalse(true);
				System.err.println("Profile is not available");
				em.writeDataToExcel("PCApplication_TestCases", 20, 2, "FAIL");
				pc.appForceQuit();
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	
		pc.appQuit();
	}

}

