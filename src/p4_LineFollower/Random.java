package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
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
		Config.isCheckingEnd = false;
		LCD.clear();
		LCD.drawString("Random", 1, 1);
		// TODO Spirale fahren
		suppressed = false;
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		movement.backward();
		while (!suppressed && SensorCache.getInstance().normalizedLightValue <= Config.lightThreshold) {
			Thread.yield();
		}
		movement.stop();
		Config.random = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
