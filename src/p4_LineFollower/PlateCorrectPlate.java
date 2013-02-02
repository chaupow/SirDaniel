package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateCorrectPlate implements Behavior{
	SensorCache sensorCache;
	UltrasonicSensor sonic;
	boolean suppressed;
	
	public PlateCorrectPlate(SensorCache sensorCache, UltrasonicSensor sonic) {
		this.sensorCache = sensorCache;
		this.sonic = sonic;
		// TODO sonic looks forward!
	}
	
	@Override
	public boolean takeControl() {
		return Config.isOnPlate && sensorCache.bumperPressed;
	}

	@Override
	public void action() {
		suppressed = false;
		if (sonic.getDistance() < Config.sonicThreshold) {
			// TODO Drehe ein wenig nach rechts
		}
		else {
			// TODO Drehe ein wenig nach links
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
}
