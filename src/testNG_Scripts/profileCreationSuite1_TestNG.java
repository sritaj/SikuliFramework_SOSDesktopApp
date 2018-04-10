package testNG_Scripts;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com> */

import static org.testng.Assert.assertFalse;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Profile;
import imageLocators.PC_App_Screens;

public class profileCreationSuite1_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	Screen sr;
	
  @Test
  /* Test Script - Verify user is able to click the Add Profile Button*/
  public void PCApp_TestCase_002_C01() {
	
		try {
			if (profile.verifyProfile()!=null) {
				profile.addProfile();
				em.writeDataToExcel("PCApplication_TestCases", 6, 2, "PASS");
			}else
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 6, 2, "FAIL");
				pc.appForceQuit();
		}catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
			
		}
  }
  
  @Test
  /* Test Script - Verify user is able to add and change the default Profile Name*/
  public void PCApp_TestCase_002_C02() {
	  try {
			profile.addProfile();
			if (profile.verifyProfileName()!=null) {
				profile.setProfileName("Dynamic");
				em.writeDataToExcel("PCApplication_TestCases", 7, 2, "PASS");
			}else {
				assertFalse(true);
				System.err.println("Profile name textfield is not active");
				em.writeDataToExcel("PCApplication_TestCases", 7, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
  }
  
  @Test
  /*Test Script - Verify by default the Save button is disabled when user clicks on Add Profile button */
  public void PCApp_TestCase_002_C03() {
	  try {
			profile.addProfile();
			if (profile.verifySave()!=null) {
				System.out.println("Save button is not active");
				em.writeDataToExcel("PCApplication_TestCases", 8, 2, "PASS");
			}else {
				assertFalse(true);
				System.err.println("Save button is active");
				em.writeDataToExcel("PCApplication_TestCases", 8, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
  }
  
   
  @Test
  /*Test Script - Verify user is able to click on the Remove Profile button to dismiss the Add Profile functionality*/
  public void PCApp_TestCase_002_C05() {
	  try {
			profile.addProfile();
			
			if(profile.verifyRemoveProfile()!=null) {
				profile.clickRemoveProfile();
				em.writeDataToExcel("PCApplication_TestCases", 10, 2, "PASS");
			}else {
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 10, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
  }
  
  
  @Test
  /*Test Script - Verify user is able to select images of valid format but with different resolution (other than 96*64) */
  public void PCApp_TestCase_002_C14() {
	  try {
			profile.addProfile();
			grid.selectGridImage("Uneven");
			
			if(profile.bitmapChecker()!=null) {
				System.out.println("User cannot select the unsupported format");
				em.writeDataToExcel("PCApplication_TestCases", 19, 2, "PASS");
			}else {
				assertFalse(true);
				System.err.println("User was able to select unspported BITMAP format");
				em.writeDataToExcel("PCApplication_TestCases", 19, 2, "FAIL");
				pc.appForceQuit();
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
