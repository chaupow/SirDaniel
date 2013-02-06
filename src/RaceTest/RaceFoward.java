package RaceTest;

import general.Movement;
import lejos.robotics.subsumption.Behavior;

public class RaceFoward implements Behavior{
	boolean suppressed;
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		Movement.getInstance().forward();
		while (!suppressed)
			Thread.yield();
		Movement.getInstance().stop();
			
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
