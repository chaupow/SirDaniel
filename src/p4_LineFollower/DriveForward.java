package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior{
	int trigger;
	
	public DriveForward(int trigger) {
		this.trigger = trigger;
	}
	

	@Override
	public boolean takeControl() {
		return Config.foundEnd || (Config.numberOfSearches == trigger && SensorCache.getInstance().normalizedLightValue >= Config.lightThreshold);
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("MUHAHAHAHAH", 1, 1);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		LCD.clear();
	}

}
