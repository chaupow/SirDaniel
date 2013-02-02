package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateStart implements Behavior {
	int threshold;
	SensorCache sensorCache;
	Movement movement;
	boolean suppressed;

	public PlateStart(SensorCache sensorCache){
		this.sensorCache = sensorCache;
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return !Config.lineFoundOnce && sensorCache.normalizedLightValue < Config.lightThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.setSpeed(1);
		movement.forward();
		while (!suppressed) {
			Thread.yield();
		} 
		movement.stop();
		movement.turn_right(30);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
