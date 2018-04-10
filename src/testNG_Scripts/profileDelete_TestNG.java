package testNG_Scripts;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com> */

import org.testng.annotations.Test;
import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Profile;
import imageLocators.PC_App_Screens;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertFalse;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;

public class profileDelete_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
	 @Test
	  /*Test Script - Verify once the user has saved the profile user is able to select the profile using the Select Profile drop down menu*/
	  public void PCApp_TestCase_002_C08() {
		  try {
				if(profile.verifyProfile()!=null) {
						profile.selectProfile();
						em.writeDataToExcel("PCApplication_TestCases", 13, 2, "PASS");
						
				}else {
					assertFalse(true);
					System.out.println("Profile is not visible");
					em.writeDataToExcel("PCApplication_TestCases", 13, 2, "FAIL");
					pc.appForceQuit();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				assertFalse(true);
			}
	  }
	 
  @Test
  /*Test Case - Verify the profile is removed when clicked on Remove Profile button*/
  public void PCApp_TestCase_004_D01() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				profile.clickRemoveProfile();
				em.writeDataToExcel("PCApplication_TestCases", 27, 2, "PASS");
			}else {
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 27, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
  }
  
  @BeforeMethod
  public void preConditions() {
		pc = new PC_App_Initialize(new Screen());
		psr = new PC_App_Screens(new Screen()); 
		em = new ExcelManipulation();
		grid = new PC_App_PicGrid(new Screen());
		scr = new PC_App_Screens(new Screen());
		profile  = new PC_App_Profile(new Screen());
		pc.appLaunch();
}

  @AfterMethod
  public void postConditions() throws FindFailed {
		pc.appQuit();
	}

}
