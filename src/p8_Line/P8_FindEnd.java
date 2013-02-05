package p8_Line;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.LCD;
import lejos.util.Delay;

public class P8_FindEnd {
	
	int threshold = P8_Config.lightThreshold;
	boolean suppressed = false;
	Movement movement = Movement.getInstance();
	
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue < threshold && P8_Config.numberOfSearches >= 1);
	}
	
	public void action() {
		suppressed = false;
		P8_Config.numberOfSearches = 0;
		
		movement.backward();
		Delay.msDelay(500);
		
		
		
	}
	
	public void suppress() {
		suppressed = true;
	}

}
