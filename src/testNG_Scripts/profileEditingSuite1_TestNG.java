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

public class profileEditingSuite1_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
  @Test 
  /* Test Script - Verify user is able to change the Profile Name*/
  public void PCApp_TestCase_003_E01() {
	  try {
			
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				try {
					profile.setProfileName("Dynamic");
					em.writeDataToExcel("PCApplication_TestCases", 20, 2, "PASS");
				}catch(Exception e) {
					e.printStackTrace();
					assertFalse(true);
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
  }
  
  @Test 
  /* Test Script - Verify user is able to change the image for a particular cell in the Pic Grid */
  public void PCApp_TestCase_003_E02() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				grid.changeGridImage("13");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "PASS");
				
			} else {
				assertFalse(true);
				System.err.println("Profile is not present");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch (Exception e) {
			
			assertFalse(true);
			e.printStackTrace();
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
