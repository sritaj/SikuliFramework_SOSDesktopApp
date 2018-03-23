package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*Verify user is able to click the Add Profile Button*/

public class PCApp_TestCase_001_C01 {
	
static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		
		
		Screen sr = new Screen();
		Pattern addprofile_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Add Profile button.png");
		Pattern cross_button = new Pattern("F:\\GitHub\\SmartOLEDSwitch\\Images\\Cross button.png");
		
		sr.click(addprofile_button);
		sr.click(cross_button);
		
	}

}
