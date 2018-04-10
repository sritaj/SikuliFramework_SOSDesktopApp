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

public class profileCreationSuite4_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
	@Test
	  /*Test Script - Verify when user saves the profile the user is navigated to default screen of the Profile tab */
	  public void PCApp_TestCase_002_C06() {
		  try {
				if (profile.verifySelectProfile()!=null) {
					profile.selectProfile();
					grid.changeGridImage("13");
					if (profile.verifySaveActive()!=null) {
						profile.clickSaveActive();
						if (profile.verifySelectProfile()!=null) {
							System.out.println("User is re-directed to Profile TAB after save");
							em.writeDataToExcel("PCApplication_TestCases", 11, 2, "PASS");
				
						}else {
							assertFalse(true);
							System.err.println("User is not in the Profile Screen");
							em.writeDataToExcel("PCApplication_TestCases", 11, 2, "FAIL");
							pc.appForceQuit();
						}
					} else {
						assertFalse(true);
						System.err.println("Save button is not active");
					}
				}else {
					assertFalse(true);
					System.err.println("Profile is not available");
				}
			}catch (Exception e) {
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
