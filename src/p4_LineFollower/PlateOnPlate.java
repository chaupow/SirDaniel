package p4_LineFollower;

import general.Movement;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateOnPlate implements Behavior{

	TouchSensor bumper;
	Movement movement;
	boolean suppressed;
	
	public PlateOnPlate(TouchSensor bumper) {
		this.bumper = bumper;
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return Config.isOnPlate && !bumper.isPressed();
	}

	@Override
	public void action() {
		suppressed = false;
		movement.setSpeed(1);
		// TODO Echte Distanz rausfinden
		if (!suppressed)
			movement.travel(30);
		while(movement.isMoving());
		Config.isOnPlate = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
