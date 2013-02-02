package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class SearchLine implements Behavior {
	SensorCache sensorCache;
	Movement movement;
	int threshold;
	boolean suppressed;
	
	public SearchLine(SensorCache sensorCache) {
		this.sensorCache = sensorCache;
		this.movement = Movement.getInstance();
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		return sensorCache.normalizedLightValue < threshold && !Config.finishedSearch;
	}
	@Override
	public void action() {
		movement.setSpeed(1);
		suppressed = false;
		int [] degrees = {10,45,90,110};
		for (int i = 0; i < degrees.length; i++) {
			if (!suppressed)
				movement.turn_right(degrees[i]);
			while(!movement.isMoving());
			if (!suppressed)
				movement.turn_left(2*degrees[i]);
			while(!movement.isMoving());
			if (!suppressed)
				movement.turn_right(degrees[i]);
			while(!movement.isMoving());
			if (i == (degrees.length-1)) {
				Config.numberOfSearches ++;
				Config.finishedSearch = true;
			}
		}
	}
	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
