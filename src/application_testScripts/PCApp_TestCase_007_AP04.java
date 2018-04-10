package application_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify when user has selected a profile and click on close button to exit the Application, user is prompted to confirm the exit */

public class PCApp_TestCase_007_AP04 {
	
	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		try {
			
			if(profile.verifyProfile()!=null) {
				profile.selectProfile();
				pc.appClose();
				if (pc.getCloseConfirmation()!=null) {
					em.writeDataToExcel("PCApplication_TestCases", 45, 2, "PASS");
				}else {
					em.writeDataToExcel("PCApplication_TestCases", 45, 2, "FAIL");
					System.err.println("No Confirmation Dialogue box to exit the PC App");
				}
			}else {
				System.err.println("Need to add profile first to verify the test case");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		pc.appForceQuit();
	}


}
