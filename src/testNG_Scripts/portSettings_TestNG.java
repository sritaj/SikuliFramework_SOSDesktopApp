package testNG_Scripts;

import org.testng.annotations.Test;
import dataManipulation.ExcelManipulation;
import genericMethods.PC_App_Initialize;
import imageLocators.PC_App_PicGrid;
import imageLocators.PC_App_Screens;
import org.testng.annotations.BeforeMethod;
import java.io.FileNotFoundException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;

public class portSettings_TestNG {
	
	PC_App_Initialize pc;
	PC_App_Screens psr;
	ExcelManipulation em;
	PC_App_Screens scr;
	PC_App_PicGrid grid;
	

  @BeforeMethod
	  public void preConditions() {
			pc = new PC_App_Initialize(new Screen());
			psr = new PC_App_Screens(new Screen()); 
			em = new ExcelManipulation();
			grid = new PC_App_PicGrid(new Screen());
			scr = new PC_App_Screens(new Screen());
			pc.appLaunch();
		}
  @Test
  public void PCApp_TestCase_005_PS01() throws FileNotFoundException {
	  try {
			psr.portSettingsTab();
			em.writeDataToExcel("PCApplication_TestCases", 29, 2, "PASS");
			
		}catch (Exception e) {
			em.writeDataToExcel("PCApplication_TestCases", 29, 2, "FAIL");
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_005_PS02() throws FileNotFoundException {
	  try {
			psr.portSettingsTab();
			psr.profileTab();
			em.writeDataToExcel("PCApplication_TestCases", 30, 2, "PASS");
		}catch(Exception e) {
			em.writeDataToExcel("PCApplication_TestCases", 30, 2, "FAIL");
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_005_PS03() throws FileNotFoundException {
	  try {
			psr.portSettingsTab();
			psr.aboutTab();
			em.writeDataToExcel("PCApplication_TestCases", 31, 2, "PASS");
		}catch (Exception e) {
			em.writeDataToExcel("PCApplication_TestCases", 31, 2, "FAIL");
			e.printStackTrace();
		}
  }
  
  @Test
  public void PCApp_TestCase_005_PS04() {
	  try {
			scr.portSettingsTab();
			
			if(grid.imageGridState()==null) {
				System.out.println("Pic grid is not active");
				em.writeDataToExcel("PCApplication_TestCases", 32, 2, "PASS");
			}else {
				System.err.println("Pic grid is active");
				em.writeDataToExcel("PCApplication_TestCases", 32, 2, "FAIL");
			}
		}catch (Exception e) {
				e.printStackTrace();
			}
  }
  

  @AfterMethod
  public void postConditions() throws FindFailed {
		pc.appQuit();
	}

}
