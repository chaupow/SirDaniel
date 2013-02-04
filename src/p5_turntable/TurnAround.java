package p5_turntable;

import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class TurnAround implements Behavior {
	
	private boolean hasTurned = false;

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed && !hasTurned;
	}

	@Override
	public void action() {
		hasTurned = false;
		Movement.getInstance().setSpeed(1);
		Movement.getInstance().travel(-30);
		Movement.getInstance().turn_left(170);
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
