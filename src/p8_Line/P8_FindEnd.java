package p8_Line;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class P8_FindEnd implements Behavior {
	
	int threshold = P8_Config.lightThreshold;
	boolean suppressed = false;
	Movement movement = Movement.getInstance();
	
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue < threshold && P8_Config.numberOfSearches == 2);
	}
	
	public void action() {
		suppressed = false;
		movement.travel(30);
		LCD.drawString("Ende", 0, 5);
//		while (!suppressed && SensorCache.getInstance().normalizedLightValue >= threshold) {
//			movement.travel(10, true);
//		}
		//TODO Ende Variable setzen!
	}
	
	public void suppress() {
		suppressed = true;
	}

}
