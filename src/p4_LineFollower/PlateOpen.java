package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateOpen implements Behavior{

	Movement movement;
	boolean suppressed;
	
	public PlateOpen() {
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
		return sensorCache.bumperPressed && !Config.isOnPlate;
	}

	@Override
	public void action() {
		suppressed = false;
		// TODO Rufe den Drehteller
		// TODO Genaue Distanz ermitteln!
		movement.setSpeed(1);
		movement.turn_left(180);
		movement.travel(-30);
		Config.isOnPlate = true;
		while (!suppressed);
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
