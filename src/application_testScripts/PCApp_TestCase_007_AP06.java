package application_testScripts;

import java.io.FileNotFoundException;

import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify when user clicks on the Cancel button on the exit dialog box, the user stays back at the same screen  */

public class PCApp_TestCase_007_AP06 {
	
public static void main(String[] args) throws FileNotFoundException {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		pc.appLaunch();
		
		try {
			profile.addProfile();
			pc.appClose();
			if (pc.getCloseConfirmation()!=null) {
				pc.cancelClose();
				em.writeDataToExcel("PCApplication_TestCases", 47, 2, "PASS");
			}else {
				System.err.println("Cancel button doesn't work");
				em.writeDataToExcel("PCApplication_TestCases", 47, 2, "FAIL");
			}
		}catch (Exception e) {
			System.err.println("Cancel button doesn't work");
			e.printStackTrace();
		}
		
		pc.appForceQuit();

	}

}
