package p4_LineFollower;

import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateCorrectPlate implements Behavior{
	TouchSensor bumper;
	UltrasonicSensor sonic;
	boolean suppressed;
	
	public PlateCorrectPlate(TouchSensor bumper, UltrasonicSensor sonic) {
		this.bumper = bumper;
		this.sonic = sonic;
		// TODO sonic looks forward!
	}
	
	@Override
	public boolean takeControl() {
		return Config.isOnPlate && bumper.isPressed();
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
