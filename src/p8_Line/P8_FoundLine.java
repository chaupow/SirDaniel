package p8_Line;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;
import general.SuperMotor;

public class P8_FoundLine implements Behavior {
	
	int threshold = P8_Config.lightThreshold;
	boolean suppressed = false; // richtig initialisiert?
	int currentAngle;
	int middle = 90;
	Movement movement = Movement.getInstance();
	//SensorCache cache = SensorCache.getInstance();
	
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue >= threshold);
	}
	
	public void action() {
		suppressed = false;
		P8_Config.numberOfSearches = 0;
		LCD.clear();
		LCD.drawString("FoundLine", 0, 0);
		
		// turn robot
		currentAngle = SuperMotor.getAngleOfArm();
		movement.steer(200, currentAngle - middle, true);
		SuperMotor.turnTo(middle, false);	
		
		// drive straight forward
		movement.forward();
		while (!suppressed) {
			LCD.drawInt(SensorCache.getInstance().normalizedLightValue, 0, 3);
			Thread.yield();
		}
	}
	
	public void suppress() {
		suppressed = true;
	}

}
