package p8_Line;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

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
		P8_Line.getInstance().stop();
	}
	
	public void suppress() {
		suppressed = true;
	}

}
