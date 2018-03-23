package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*Verify user is able to navigate to Port Settings tab from About us tab*/

public class PCApp_TestCase_001_A03 {
	
static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern aboutus_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\About tab.png");
		Pattern portsettings_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Port Settings tab.png");
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		
		sr.click(aboutus_tab);
		sr.click(portsettings_tab);
		sr.click(cross_button);
		
		
	}

}
