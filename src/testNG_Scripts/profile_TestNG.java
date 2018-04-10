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

public class profile_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
  @Test
  /* Test Script - Verify when the App is launched user is by default in Profile tab*/
  public void PCApp_TestCase_001_P01() {
	  try {
			if(profile.verifyProfile()!=null) {
				System.out.println("User is in the Profile Tab");
				em.writeDataToExcel("PCApplication_TestCases", 3, 2, "PASS");
				pc.appForceQuit();
				
			}else {
				System.err.println("Profile Tab is not default");
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 3, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			assertFalse(true);
			e.printStackTrace();
		}
  }
  
  @Test
  /* Test Script - Verify the Pic Grid contains 16 cells */
  public void PCApp_TestCase_001_P02() {
	  try {
			if(grid.imageGridState()==null) {
				System.out.println("Pic grid is not active");
				em.writeDataToExcel("PCApplication_TestCases", 4, 2, "PASS");
			}else {
				System.err.println("Pic grid is active");
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 4, 2, "FAIL");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			assertFalse(true);
			e.printStackTrace();
		}
  }
  
  @Test
  /* Test Script - Verify the Pic Grid contains 16 cells */ 
  public void PCApp_TestCase_001_P03() {
	  try {
			int expectedResult = 16;
			int actualResult = grid.gridCounts();
			if (expectedResult == actualResult ) {
				System.out.println("Pic grid is having " + actualResult + " cells");
				em.writeDataToExcel("PCApplication_TestCases", 5, 2, "PASS");
			}else {
				System.err.println("Pic grid doesn't meet requirements " + actualResult);
				assertFalse(true);
				em.writeDataToExcel("PCApplication_TestCases", 5, 2, "PASS");
				pc.appForceQuit();
			}
		}catch(Exception e) {
			assertFalse(true);
			e.printStackTrace();
		}
  }
  
  @Test
  /*Test Script - Verify Profile selection when no Profile is created */
  public void PCApp_TestCase_003_E03() {
	  try {
			if (profile.verifySelectProfile()==null) {
				System.out.println("No profile is created");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "PASS");
			}else {
				assertFalse(true);
				System.err.println("Profile is present");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "FAIL");
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
