package profile_testScripts;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_Profile;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This is a test script to automate the test case described below

Test Case - Verify when the App is launched user is by default in Profile tab*/

public class PCApp_TestCase_001_P01 {

	public static void main(String[] args) throws FindFailed {
		
		PC_App_Initialize pc = new PC_App_Initialize(new Screen());
		PC_App_Profile profile = new PC_App_Profile(new Screen());
		
		pc.appLaunch();
		
		if(profile.verifyProfile()!=null) {
			System.out.println("User is in the Profile Tab");
		}else {
			System.err.println("Profile t=Tab is not default");
		}
		
		pc.appQuit();
	}
	
}
