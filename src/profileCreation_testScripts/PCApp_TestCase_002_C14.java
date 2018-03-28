package profileCreation_testScripts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify user is able to select images of valid format but with different resolution (other than 96*64) */

public class PCApp_TestCase_002_C14 {
	
	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		PC_App_PicGrid grid = new PC_App_PicGrid(new Screen());
		
		pc.appLaunch();
		profile.addProfile();
		grid.selectGridImage("Uneven");
		
		if(profile.bitmapChecker()!=null) {
			System.out.println("User cannot select the unsupported format");
		}else {
			System.err.println("User was able to select unspported BITMAP format");
		}
	
		pc.appQuit();
}

}
