package testNG_Scripts;

import org.testng.annotations.Test;
import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Profile;
import imageLocators.PC_App_Screens;
import org.testng.annotations.BeforeMethod;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;

public class profileEditing_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	PC_App_Profile profile;
	
  @Test
  public void PCApp_TestCase_003_E01() {
	  try {
			
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				profile.setProfileName("Dynamic");
				em.writeDataToExcel("PCApplication_TestCases", 20, 2, "PASS");
			}else {
				System.err.println("Profile is not available");
				em.writeDataToExcel("PCApplication_TestCases", 20, 2, "FAIL");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E02() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				grid.changeGridImage("13");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "PASS");
				
			} else {
				System.err.println("Profile is not present");
				em.writeDataToExcel("PCApplication_TestCases", 21, 2, "FAIL");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E03() {
	  try {
			if (profile.verifySelectProfile()==null) {
				System.out.println("No profile is created");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "PASS");
			}else {
				System.err.println("Profile is present");
				em.writeDataToExcel("PCApplication_TestCases", 22, 2, "FAIL");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E04() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				profile.setProfileName("Dynamic");
				if (profile.verifySaveActive()!=null) {
					profile.clickSaveActive();
					em.writeDataToExcel("PCApplication_TestCases", 23, 2, "PASS");
				} else {
					System.err.println("Save button is not active");
					em.writeDataToExcel("PCApplication_TestCases", 23, 2, "FAIL");
				}
			}else {
				System.err.println("Profile is not available");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E05() {
	  try {
			
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				grid.changeGridImage("13");
				if (profile.verifySaveActive()!=null) {
					profile.clickSaveActive();
					em.writeDataToExcel("PCApplication_TestCases", 24, 2, "PASS");
				} else {
					System.err.println("Save button is not active");
					em.writeDataToExcel("PCApplication_TestCases", 24, 2, "FAIL");
				}
			}else {
				System.err.println("Profile is not available");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E06() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				profile.setProfileName("Rocket");
				grid.changeGridImage("13");
				em.writeDataToExcel("PCApplication_TestCases", 25, 2, "PASS");
				
			} else {
				System.err.println("Profile is not present");
				em.writeDataToExcel("PCApplication_TestCases", 25, 2, "FAIL");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_003_E07() {
	  try {
			if (profile.verifySelectProfile()!=null) {
				profile.selectProfile();
				profile.setProfileName("Rocket");
				grid.changeGridImage("13");
				if (profile.verifySaveActive()!=null) {
					profile.clickSaveActive();
					em.writeDataToExcel("PCApplication_TestCases", 26, 2, "PASS");
				} else {
					System.err.println("Save button is not active");
					em.writeDataToExcel("PCApplication_TestCases", 26, 2, "FAIL");
				}
			}else {
				System.err.println("Profile is not available");
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
