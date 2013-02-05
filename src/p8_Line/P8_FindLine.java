package p8_Line;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import p4_LineFollower.Config;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class P8_FindLine implements Behavior {
	
	int threshold = P8_Config.lightThreshold;
	int[] degrees = {10, 30, 90};
	int middle = 90;
	int turns = 0;
	boolean suppressed = false;	// richtig initialisiert?
	Movement movement = Movement.getInstance();
	int j = 0;
	//SensorCache cache = SensorCache.getInstance();
	
	public P8_FindLine() {
		
	}
	
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue < threshold);
	}
	
	public void action() {
		suppressed = false;
		int i = 0;
		movement.stop();
		turns = 0;

		LCD.clear();
		LCD.drawString("FindLine", 0, 1);
		
		if (P8_Config.leftTurn) {
			while (SensorCache.getInstance().normalizedLightValue < threshold && i < degrees.length && !suppressed) {
				// + means to the left
				P8_Config.leftTurn = true;
				if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) {
					SuperMotor.turnTo(middle + degrees[i], true);
					turns++;
				}
				while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed) {
					LCD.drawInt(SensorCache.getInstance().normalizedLightValue, 0, 4);
				}
				
				P8_Config.leftTurn = false;
				if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) {
					SuperMotor.turnTo(middle - degrees[i], true);
					turns++;
				}
				while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed) {
					LCD.drawInt(SensorCache.getInstance().normalizedLightValue, 0, 4);
				}
				
				i++;
			}
		} else {
			while (SensorCache.getInstance().normalizedLightValue < threshold && i < degrees.length && !suppressed) {
				// - means to the right
				P8_Config.leftTurn = false;
				if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) {
					SuperMotor.turnTo(middle - degrees[i], true);
					turns++;
				}
				while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed);
				
				P8_Config.leftTurn = true;
				if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) {
					SuperMotor.turnTo(middle + degrees[i], true);
					turns++;
				}
				while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed);
				
				i++;
			}
		}
		
		// getting here means the line has not been found
		movement.stop();
//		LCD.drawString("" + P8_Config.lost, 0, 5);
		LCD.drawString("" + P8_Config.numberOfSearches, 0, 6);
//		if (SensorCache.getInstance().normalizedLightValue < threshold) {
		if (turns == degrees.length * 2) {
			LCD.drawString("nrSearch++", 0, 6);
			P8_Config.numberOfSearches++;
		}
		
		
	}
	
	public void suppress() {
		suppressed = true;
	}
}
