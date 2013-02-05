package p5_turntable;

import general.Movement;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class TurnAround implements Behavior {

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed && !Config.hasTurned;
	}

	@Override
	public void action() {
		Config.hasTurned = true;
		Movement.getInstance().setSpeed(1);
		Movement.getInstance().travel(-30);
		Movement.getInstance().turn_left(170);
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
