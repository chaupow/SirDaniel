package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class GapCrossGap implements Behavior{
	Movement movement = Movement.getInstance();
	boolean suppressed;
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches == 1;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("GapCrossGap", 1, 1);
		suppressed = false;
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		Config.finishedSearch = false;
		// TODO echte Distanz rauskriegen
		if (!suppressed)
			movement.travel(72, true);
		while (movement.isMoving() && SensorCache.getInstance().normalizedLightValue <= Config.lightThreshold) {Thread.yield();}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
