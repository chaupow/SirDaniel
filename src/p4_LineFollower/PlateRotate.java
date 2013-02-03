package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateRotate implements Behavior {
	
	public PlateRotate() {
	}
	
	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
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
