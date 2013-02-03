package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateOnPlate implements Behavior{

	Movement movement;
	boolean suppressed;
	
	public PlateOnPlate() {
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
		return Config.isOnPlate && !sensorCache.bumperPressed;
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
