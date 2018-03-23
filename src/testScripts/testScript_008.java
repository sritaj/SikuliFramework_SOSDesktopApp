package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/* Test Script to verify user action on Save button without selecting Images */

public class testScript_008 {

static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern addprofile_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Add Profile button.png");
		Pattern profilename_textfield = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Profile Name textfield.png");
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		Pattern save_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Save button.png");
		Pattern savedisabled_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Save Disabled button.png");
		
		sr.click(addprofile_button);
		sr.click(profilename_textfield);
		sr.type("a", Key.CTRL);
//		sr.type(Key.BACKSPACE);
		sr.write("Dynamic");
		
		if (save_button.isValid()) {
			
			sr.click(save_button);
			System.out.println("Test Script Failed, Save button should be disabled");
		}else {
			sr.click(savedisabled_button);
			System.out.println("Test Script is Passed, Save button is disabled");
		}
		
		sr.click(cross_button);
		
	}
}
