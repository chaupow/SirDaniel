package p5_turntable;

import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class TurnIt implements Behavior {

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
