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

public class profileCreationSuite2_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
	@Test
	  /*Test Script - Verify the Save button is enabled after selecting all the 16 imaged in the Pic Grid */
	  public void PCApp_TestCase_002_C04() {
		  try {
				profile.addProfile();
				
				grid.selectAllGridImage("14");
				
				if (profile.verifySaveActive()!=null) {
					System.out.println("Save button is active");
					em.writeDataToExcel("PCApplication_TestCases", 9, 2, "PASS");
				}else {
					assertFalse(true);
					System.err.println("Save button is not active");
					em.writeDataToExcel("PCApplication_TestCases", 9, 2, "FAIL");
					pc.appForceQuit();
				}
			}catch (Exception e) {
				e.printStackTrace();
				assertFalse(true);
			}
	  }
	
	 @Test
	  /*Test Script - Verify user is able to select the image for a particular cell in the Pic Grid*/
	  public void PCApp_TestCase_002_C09() {
		  try {
				if (profile.verifyProfile()!=null) {
					profile.addProfile();
					grid.selectGridImage("13");
					em.writeDataToExcel("PCApplication_TestCases", 14, 2, "PASS");
					
				}else {
					assertFalse(true);
					System.out.println("Profile is not visible");
					em.writeDataToExcel("PCApplication_TestCases", 14, 2, "FAIL");
					pc.appForceQuit();
				}
			}catch (Exception e) {
					e.printStackTrace();
					assertFalse(true);
				}
	  }
	  
	  @Test
	 /* Test Script - Verify user is able to select multiple images for the Pic Grid */
	  public void PCApp_TestCase_002_C10() {
		  try {
				if(profile.verifyProfile()!=null) {
					profile.addProfile();
					grid.selectAllGridImage("14");
					em.writeDataToExcel("PCApplication_TestCases", 15, 2, "PASS");
				}else {
					assertFalse(true);
					em.writeDataToExcel("PCApplication_TestCases", 15, 2, "FAIL");
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
