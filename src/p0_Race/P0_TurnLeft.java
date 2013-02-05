package p0_Race;

import lejos.robotics.subsumption.Behavior;
import general.Calibration;
import general.Movement;
import general.SensorCache;


public class P0_TurnLeft implements Behavior {
	
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public P0_TurnLeft(int speed, int rotationSpeed) {
		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);
	}
	
	public boolean takeControl() {
		return (SensorCache.getInstance().bumperPressed);
	}
	
	public void action() {
		suppressed = false;
		Constants.alreadyStopped = false;
		movement.setTravelSpeed(100);

		movement.arcBackward(-40);
		movement.turn_left(90);		
	}
	
	public void suppress() {
		suppressed = true;
	}
}
