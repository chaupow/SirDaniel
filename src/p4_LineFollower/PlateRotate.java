package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateRotate implements Behavior {
	SensorCache sensorCache;
	
	public PlateRotate(SensorCache sensorCache) {
		this.sensorCache = sensorCache;
	}
	
	@Override
	public boolean takeControl() {
		return Config.isOnPlate && sensorCache.bumperPressed && !Config.isPlateRotated;
	}

	@Override
	public void action() {
		// TODO Rotate Drehscheibe
	}

	@Override
	public void suppress() {
	}

}
