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

public class profileEditingSuite3_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
  
	@Test
	  /*Test Case - Verify user is able to save the new set Profile Name */
	  public void PCApp_TestCase_003_E04() {
		  try {
				if (profile.verifySelectProfile()!=null) {
					profile.selectProfile();
					profile.setProfileName("Dynamic");
					if (profile.verifySaveActive()!=null) {
						profile.clickSaveActive();
						em.writeDataToExcel("PCApplication_TestCases", 23, 2, "PASS");
					} else {
						assertFalse(true);
						System.err.println("Save button is not active");
						em.writeDataToExcel("PCApplication_TestCases", 23, 2, "FAIL");
						pc.appForceQuit();
					}
				}else {
					System.err.println("Profile is not available");
				}
				
			}catch (Exception e) {
				
				assertFalse(true);
				e.printStackTrace();
			}
	  }
	  
	  @Test
	  /*Test Script - Verify user is able to change the image for a particular cell in the Pic Grid and save it */
	  public void PCApp_TestCase_003_E05() {
		  try {
				
				if (profile.verifySelectProfile()!=null) {
					profile.selectProfile();
					grid.changeGridImage("13");
					if (profile.verifySaveActive()!=null) {
						profile.clickSaveActive();
						em.writeDataToExcel("PCApplication_TestCases", 24, 2, "PASS");
					} else {
						assertFalse(true);
						System.err.println("Save button is not active");
						em.writeDataToExcel("PCApplication_TestCases", 24, 2, "FAIL");
						pc.appForceQuit();
					}
				}else {
					System.err.println("Profile is not available");
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
