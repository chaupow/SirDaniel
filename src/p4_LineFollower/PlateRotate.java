package p4_LineFollower;

import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateRotate implements Behavior {
	TouchSensor bumper;
	
	public PlateRotate(TouchSensor bumper) {
		this.bumper = bumper;
	}
	
	@Override
	public boolean takeControl() {
		return Config.isOnPlate && bumper.isPressed() && !Config.isPlateRotated;
	}

	@Override
	public void action() {
		// TODO Rotate Drehscheibe
	}

	@Override
	public void suppress() {
	}

}
