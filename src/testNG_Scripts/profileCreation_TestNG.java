package testNG_Scripts;

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

public class profileCreation_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
  @Test
  public void PCApp_TestCase_002_C01() {
		try {
			if (profile.verifyProfile()!=null) {
				profile.addProfile();
				em.writeDataToExcel("PCApplication_TestCases", 6, 2, "PASS");
			}else
				em.writeDataToExcel("PCApplication_TestCases", 6, 2, "FAIL");
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C02() {
	  try {
			profile.addProfile();
			if (profile.verifyProfileName()!=null) {
				profile.setProfileName("Dynamic");
				em.writeDataToExcel("PCApplication_TestCases", 7, 2, "PASS");
			}else {
				System.err.println("Profile name textfield is not active");
				em.writeDataToExcel("PCApplication_TestCases", 7, 2, "FAIL");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C03() {
	  try {
			profile.addProfile();
			if (profile.verifySave()!=null) {
				System.out.println("Save button is not active");
				em.writeDataToExcel("PCApplication_TestCases", 8, 2, "PASS");
			}else {
				System.err.println("Save button is active");
				em.writeDataToExcel("PCApplication_TestCases", 8, 2, "FAIL");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C04() {
	  try {
			profile.addProfile();
			
			grid.selectAllGridImage("14");
			
			if (profile.verifySaveActive()!=null) {
				System.out.println("Save button is active");
				em.writeDataToExcel("PCApplication_TestCases", 9, 2, "PASS");
			}else {
				System.err.println("Save button is not active");
				em.writeDataToExcel("PCApplication_TestCases", 9, 2, "FAIL");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C05() {
	  try {
			profile.addProfile();
			
			if(profile.verifyRemoveProfile()!=null) {
				profile.clickRemoveProfile();
				em.writeDataToExcel("PCApplication_TestCases", 10, 2, "PASS");
			}else {
				em.writeDataToExcel("PCApplication_TestCases", 10, 2, "FAIL");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
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
						System.err.println("User is not in the Profile Screen");
						em.writeDataToExcel("PCApplication_TestCases", 11, 2, "FAIL");
					}
				} else {
					System.err.println("Save button is not active");
				}
			}else {
				System.err.println("Profile is not available");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C08() {
	  try {
			if(profile.verifyProfile()!=null) {
					profile.selectProfile();
					em.writeDataToExcel("PCApplication_TestCases", 13, 2, "PASS");
					
			}else {
				System.out.println("Profile is not visible");
				em.writeDataToExcel("PCApplication_TestCases", 13, 2, "FAIL");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C09() {
	  try {
			if (profile.verifyProfile()!=null) {
				profile.addProfile();
				grid.selectGridImage("13");
				em.writeDataToExcel("PCApplication_TestCases", 14, 2, "PASS");
				
			}else {
				System.out.println("Profile is not visible");
				em.writeDataToExcel("PCApplication_TestCases", 14, 2, "FAIL");
			}
		}catch (Exception e) {
				e.printStackTrace();
			}
  }
  
  @Test
  public void PCApp_TestCase_002_C10() {
	  try {
			if(profile.verifyProfile()!=null) {
				profile.addProfile();
				grid.selectAllGridImage("14");
				em.writeDataToExcel("PCApplication_TestCases", 15, 2, "PASS");
			}else {
				em.writeDataToExcel("PCApplication_TestCases", 15, 2, "FAIL");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C12() {
	  try {
			profile.addProfile();
			grid.selectGridImage("13");
			
			if(profile.verifySave()!=null) {
				System.out.println("Save button is not active");
				em.writeDataToExcel("PCApplication_TestCases", 17, 2, "PASS");
			}else {
				System.err.println("Save button is active");
				em.writeDataToExcel("PCApplication_TestCases", 17, 2, "FAIL");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C13() {
	  try {
			
			profile.addProfile();
			profile.setProfileName("Entertainment");
			grid.selectAllGridImage("14");
			
			if (profile.verifySaveActive()!=null) {
				profile.clickSaveActive();
				em.writeDataToExcel("PCApplication_TestCases", 18, 2, "PASS");
			}else {
				System.err.println("Unable to save the profile");
				em.writeDataToExcel("PCApplication_TestCases", 18, 2, "FAIL");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_002_C14() {
	  try {
			profile.addProfile();
			grid.selectGridImage("Uneven");
			
			if(profile.bitmapChecker()!=null) {
				System.out.println("User cannot select the unsupported format");
				em.writeDataToExcel("PCApplication_TestCases", 19, 2, "PASS");
			}else {
				System.err.println("User was able to select unspported BITMAP format");
				em.writeDataToExcel("PCApplication_TestCases", 19, 2, "FAIL");
			}
		}catch (Exception e) {
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
