package p4_LineFollower;

import general.Movement;
import lejos.robotics.subsumption.Behavior;

public class Random implements Behavior{
	Movement movement = Movement.getInstance();
	boolean suppressed;

	@Override
	public boolean takeControl() {
		return Config.random;
	}

	@Override
	public void action() {
		// TODO Spirale fahren
		suppressed = false;
		movement.setSpeed(1);
		movement.forward();
		while (!suppressed) {
			Thread.yield();
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
