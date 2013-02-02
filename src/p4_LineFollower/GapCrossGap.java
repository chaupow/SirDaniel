package p4_LineFollower;

import general.Movement;
import lejos.robotics.subsumption.Behavior;

public class GapCrossGap implements Behavior{
	Movement movement = Movement.getInstance();
	boolean suppressed;
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches >= 1;
	}

	@Override
	public void action() {
		if (Config.numberOfSearches > 1)
			Config.random = true;
		suppressed = false;
		movement.setSpeed(1);
		// TODO echte Distanz rauskriegen
		if (!suppressed)
			movement.travel(30);
		while (movement.isMoving());
		Config.finishedSearch = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
