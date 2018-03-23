package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*Verify user is navigated to Port Settings screen when clicked on the Port Settings tab*/

public class PCApp_TestCase_001_P01 {
	
static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		Pattern portsettings_tab = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Port Settings tab.png");
		
		sr.click(portsettings_tab);
		sr.click(cross_button);
		
		
	}

}
