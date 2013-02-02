package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateOnPlate implements Behavior{

	Movement movement;
	SensorCache sensorCache;
	boolean suppressed;
	
	public PlateOnPlate(SensorCache sensorCache) {
		this.sensorCache = sensorCache;
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
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
