package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {
	Movement movement;
	SensorCache sensorCache;
	int threshold;
	boolean suppressed;
	
	public FollowLine(SensorCache sensorCache) {
		this.movement = Movement.getInstance();
		this.sensorCache = sensorCache;
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = sensorCache.normalizedLightValue;
		return (lightvalue >= threshold);
	}
	
	@Override
	public void action() {
		Config.random = false;
		Config.finishedSearch = false;
		Config.numberOfSearches = 0;
		suppressed = false;
		movement.setSpeed(2);
		movement.forward();
		while(!suppressed) {
			Thread.yield();
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
