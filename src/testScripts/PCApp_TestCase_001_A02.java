package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*Verify user is able to navigate to Profile tab from About us tab*/

public class PCApp_TestCase_001_A02 {
	
static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern aboutus_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\About tab.png");
		Pattern profile_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Profile tab.png");
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		
		sr.click(aboutus_tab);
		sr.click(profile_tab);
		sr.click(cross_button);
		
		
	}


}
