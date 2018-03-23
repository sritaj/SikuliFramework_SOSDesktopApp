package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Test Script to verify user action on Save button without adding or selecting a profile */

public class testScript_009 {
	
static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		Pattern save_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Save button.png");
		Pattern savedisabled_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Save Disabled button.png");
		
        if (savedisabled_button.isValid()) {
			
			System.out.println("Test Script Passed, Save button is disabled");
			
		}else{
			
			sr.click(save_button);
			System.out.println("Test Script is Failed, Save button is disabled");
		}
		
		sr.click(cross_button);
		
	}

}
