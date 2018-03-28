package imageLocators;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This class contains the Methods that is used to interact with the UI Elements and carry out operations in the Profile screen */

public class PC_App_Profile {
	
	public PC_App_Profile(Screen sr) {
		this.sr = sr;
	}
	
	/* Below Screen class is initialized and path to required images are stored in the Strings defined */ 
	
	String addprofile = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Add Profile button.png";
	String profilename = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Profile Name textfield.png";
	String saveactive = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Save button.png";
	String savedisabled = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Save Disabled button.png";
	String removeprofile = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Remove Profile button.png";
	String selectprofile = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Select Profile dropdown.png";
	String profilecount = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Saved Profile count.png";
	String bitmapUnsupported = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Bitmap uneven.png";
	
	Screen sr;
	
	/* This method is to verify if the add profile button is present and returns the value */ 
	public Match verifyProfile() {
		
		Pattern addprofile_button = new Pattern(addprofile);
		return sr.exists(addprofile_button);
		
		
	}
	
	/* This method is to used to click on the add profile button */ 
	public void addProfile() throws FindFailed {
		
		Pattern addprofile_button = new Pattern(addprofile);
		sr.click(addprofile_button);
			
	}
	
	/* This method is to verify if the profile name textfield is present and returns the value */ 
	public Match verifyProfileName() {
		
		Pattern profilename_textfield = new Pattern(profilename);
		return sr.exists(profilename_textfield);
	}
	
	/* This method is to set the profile name */ 
	public void setProfileName(String profileName) throws FindFailed {

		
		Pattern profilename_textfield = new Pattern(profilename);
		sr.click(profilename_textfield);
		sr.type("a", Key.CTRL);
		sr.type(profileName);
		
	}
	
	/* This method is to verify if the default Save button (disabled state) is present and returns the value */ 
	public Match verifySave() {
		
		Pattern savedisabled_button = new Pattern(savedisabled);
		return sr.exists(savedisabled_button);
	}
	
	/* This method is to verify if the active Save button is present and returns the value */ 
	public Match verifySaveActive() {
		
		Pattern save_button = new Pattern(saveactive);
		return sr.exists(save_button);
	}
	
	/* This method is to click on the active Save button */ 
	public void clickSaveActive() throws FindFailed {
		Pattern save_button = new Pattern(saveactive);
		sr.click(save_button);
	}

	/* This method is to verify if the Remove button is present and returns the value */ 
	public Match verifyRemoveProfile() {
		
		Pattern removeprofile_button = new Pattern(removeprofile);
		
		   return sr.exists(removeprofile_button);
	}
	
	/* This method is to click on the Remove profile button */ 
	public void clickRemoveProfile() throws FindFailed {
		
		Pattern removeprofile_button = new Pattern(removeprofile);
		sr.click(removeprofile_button);
	}
	
	/* This method is to verify if the Select Profile dropdown is present and returns the value */ 
	public Match verifySelectProfile() {
		
		Pattern selectprofile_dropdown = new Pattern(selectprofile);
		
		   return sr.exists(selectprofile_dropdown);
		
	}

	/* This method is to select a Profile from the dropdown menu */ 
	public void selectProfile() throws FindFailed {
		
		Pattern selectprofile_dropdown = new Pattern(selectprofile);
		sr.click(selectprofile_dropdown);
		sr.type(Key.DOWN);
		sr.click();	
		
	}
	
	public Match profileCount() throws FindFailed {
		
		Pattern profile_count = new Pattern(profilecount);
		return sr.exists(profile_count);
	
	}	
	
	public String countProfiles() throws FindFailed {
		
		Pattern profile_count = new Pattern(profilecount);
		String text = sr.find(profile_count).text();
		return text;
	
	}
	
	/* This method is to verify if the error popup for unsupported bitmap is present and returns the value */ 
	public Match bitmapChecker() {
		
		Pattern bitmap_unsupported = new Pattern(bitmapUnsupported);
		
		return sr.exists(bitmap_unsupported);
	}
	
	
	
}


