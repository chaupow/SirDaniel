package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateCorrectPlate implements Behavior{

	UltrasonicSensor sonic;
	boolean suppressed;
	
	public PlateCorrectPlate(UltrasonicSensor sonic) {
		this.sonic = sonic;
		// TODO sonic looks forward!
	}
	
	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
		return Config.isOnPlate && sensorCache.bumperPressed;
	}

	@Override
	public void action() {
		suppressed = false;
		// TODO Drehe nach rechts vorne
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
