package genericMethods;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Copyright (C) 2018 by Unizen Technologies Pvt Ltd.                               
This file is part of Automation Test Suite for Smart OLED Switch Project 					
 
@author Sritaj <sritajpatel@unizentechnologies.com>
@brief - This class contains the Methods that is used to open and close the Application */

public class PC_App_Initialize {
	
	
	public PC_App_Initialize(Screen sr) {
		this.sr = sr;
	}
	
	/* Below Screen class is initialized and path to required images and file are stored in the Strings defined */ 
	Screen sr;
	String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	String crossbutton = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png";
	
	/* This method is used to launch the App */ 
	public void appLaunch() {
		
		App.open(appPath);
		
	}
	
	/* This method is used to close the App */ 
	public void appQuit() throws FindFailed {
		
		Pattern cross_button = new Pattern(crossbutton);
		sr.click(cross_button);
	}

}
