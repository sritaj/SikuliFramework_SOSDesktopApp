package application_testScripts;

import java.io.FileNotFoundException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to launch the exe PC Application */

public class PCApp_TestCase_007_AP01 {
	
	public static void main(String[] args) throws FileNotFoundException, FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		ExcelManipulation em = new ExcelManipulation();
		
		try {
			pc.appLaunch();
			em.writeDataToExcel("PCApplication_TestCases", 42, 2, "PASS");
		}catch(Exception e) {
			em.writeDataToExcel("PCApplication_TestCases", 42, 2, "FAIL");
		}
		
		pc.appQuit();
	}

}
