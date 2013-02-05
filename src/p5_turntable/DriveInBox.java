package p5_turntable;

import general.Movement;
import general.SensorCache;
import general.Settings;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class DriveInBox implements Behavior{
	Movement movement = Movement.getInstance();
	boolean suppressed;

	@Override
	public boolean takeControl() {
		return (p4_LineFollower.Config.random && Settings.turntable);
	}

	@Override
	public void action() {
		p4_LineFollower.Config.isCheckingEnd = false;
		LCD.clear();
		LCD.drawString("Random", 1, 1);
		// TODO Spirale fahren
		suppressed = false;
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		movement.forward();
		while (!suppressed && SensorCache.getInstance().normalizedLightValue <= p4_LineFollower.Config.lightThreshold) {
			Thread.yield();
		}
		movement.stop();
		p4_LineFollower.Config.random = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
