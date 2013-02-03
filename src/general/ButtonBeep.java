package general;

import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class ButtonBeep implements Behavior{
	
	public boolean takeControl(){
		return SensorCache.getInstance().bumperPressed;
	}
	
	public void suppress(){
		
	}
	
	public void action(){
		Sound.beepSequenceUp();
	}

}
