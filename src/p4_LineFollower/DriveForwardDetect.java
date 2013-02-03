package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class DriveForwardDetect implements Behavior{
	int trigger;
	
	public DriveForwardDetect(int trigger) {
		this.trigger = trigger;
	}
	
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches == trigger && SensorCache.getInstance().normalizedLightValue >= Config.lightThreshold;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("DriveFowardDetect", 1, 1);
		Config.foundEnd = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
