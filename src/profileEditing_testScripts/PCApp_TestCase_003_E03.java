package profileEditing_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify Profile selection when no Profile is created */

public class PCApp_TestCase_003_E03 {
	
	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		try {
			if (profile.verifySelectProfile()==null) {
				System.out.println("No profile is created");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "PASS");
			}else {
				System.err.println("Profile is present");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "FAIL");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		pc.appQuit();
	}

}
