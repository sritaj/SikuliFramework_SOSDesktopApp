package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Verify user is navigated to About us screen when clicked on the About Us tab */

public class PCApp_TestCase_001_A01 {

static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		Pattern aboutus_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\About tab.png");
		
		sr.click(aboutus_tab);
		sr.click(cross_button);
		
		
		
	}
}
