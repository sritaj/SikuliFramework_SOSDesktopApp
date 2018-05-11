package imageLocators;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class PC_App_PortSettings {
	
	Screen sr;
	
	public PC_App_PortSettings(Screen sr) {
		
		this.sr = sr;
	}
	
	String loaddisabled = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Load Disabled button.png";
	String portDropDown = "F:\\GitHub\\SmartOLEDSwitch\\Images\\Port.png";
	
	public Match verifyLoadDisabled() {
		
		Pattern loaddisabled_button = new Pattern(loaddisabled);
		return sr.exists(loaddisabled_button);
	}
	
    public Match verifyPort() {
		
		Pattern port_dropdown = new Pattern(portDropDown);
		return sr.exists(port_dropdown);
	}
    
    public void selectPort() throws FindFailed {
    	Pattern port_dropdown = new Pattern(portDropDown);
    	sr.click(port_dropdown);
		sr.type(Key.DOWN);
		sr.click();	
    	
    }
    
    

}
