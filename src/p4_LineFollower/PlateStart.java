package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateStart implements Behavior {
	int threshold;
	Movement movement;
	boolean suppressed;

	public PlateStart(){
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
		return !Config.lineFoundOnce && sensorCache.normalizedLightValue < Config.lightThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.setSpeed(1);
		movement.forward();
		while (!suppressed && !Config.lineFoundOnce && SensorCache.getInstance().normalizedLightValue < Config.lightThreshold) {
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
