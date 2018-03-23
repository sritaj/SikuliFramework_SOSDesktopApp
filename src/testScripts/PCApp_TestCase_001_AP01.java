package testScripts;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;

/*Verify user is able to launch the exe PC Application*/

public class PCApp_TestCase_001_AP01{
	
	static String appPath = "F:\\GitHub\\SmartOLEDSwitch\\App\\SOS.exe";
	
	public static void main(String[] args) throws FindFailed {
	
		App.open(appPath);
		App.close(appPath);
	}

}
