package profile_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify the Pic Grid contains 16 cells */

public class PCApp_TestCase_001_P03 {

	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		
		pc.appLaunch();
		int expectedResult = 16;
		int actualResult = grid.gridCounts();
		if (expectedResult == actualResult ) {
			System.out.println("Pic grid is having " + actualResult + " cells");
		}else {
			System.err.println("Pic grid doesn't meet requirements");
		}
		pc.appQuit();

	}

}
