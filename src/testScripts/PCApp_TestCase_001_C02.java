package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*Verify user is able to change the Profile Name*/

public class PCApp_TestCase_001_C02 {

static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern addprofile_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Add Profile button.png");
		Pattern profilename_textfield = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Profile Name textfield.png");
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		
		sr.click(addprofile_button);
		sr.click(profilename_textfield);
		sr.type("a", Key.CTRL);
//		sr.type(Key.BACKSPACE);
		sr.write("Dynamic");
		sr.click(cross_button);
		
	}
}
