package imageLocators;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This class contains the Methods that is used to interact with the UI Elements and carry out operations in the different Tabs */

public class PC_App_Screens {
	
	public PC_App_Screens(Screen sr) {
		this.sr = sr;
	}
	
	/* Below Screen class is initialized and path to required images are stored in the Strings defined */ 
	
	String profiletab = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Profile tab.png";
	String portsettingstab = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Port Settings tab.png";
	String abouttab = "F:\\GitHub\\SmartOLEDSwitch\\Images\\About tab.png";
	Screen sr;
	
	/* This method is to used to click on Profile tab */ 
	public void profileTab() throws FindFailed{
		
		Pattern profile_tab = new Pattern(profiletab);
		sr.click(profile_tab);
		
	}
	
	/* This method is to used to click on Port Settings tab */ 
	public void portSettingsTab() throws FindFailed {
		
		Pattern portsettings_tab = new Pattern(portsettingstab);
		sr.click(portsettings_tab);
		
	}
	
	/* This method is to used to click on About tab */ 
	public void aboutTab() throws FindFailed {

		
		Pattern aboutus_tab = new Pattern(abouttab);
		sr.click(aboutus_tab);
		
	}

}
