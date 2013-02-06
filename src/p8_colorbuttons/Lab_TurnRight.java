package p8_colorbuttons;

import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;

public class Lab_TurnRight implements Behavior {
	
	boolean suppressed;
	Movement movement = Movement.getInstance();
	ColorButtons cb;

	public Lab_TurnRight(int speed, int rotationSpeed, ColorButtons cb) {
		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);
		this.cb = cb;
	}
	
	public boolean takeControl() {
		return (SensorCache.getInstance().bumperPressed && cb.lab);
	}
	
	public void action() {
		suppressed = false;

		movement.arcBackward(40);
		//movement.steerBackward(-40);
		
		movement.turn_right(90);
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
