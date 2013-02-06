package RaceTest;

import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class RaceTurn implements Behavior{
	boolean suppressed;
	RaceTest rt;
	
	public RaceTurn (RaceTest rt) {
		this.rt = rt;
	}

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed;
	}

	@Override
	public void action() {
		Movement.getInstance().setRotateSpeed(Movement.getInstance().getMaxRotateSpeed());
		suppressed = false;
		Delay.msDelay(1000);
		if (SensorCache.getInstance().bumperPressed && !suppressed) {
			if (rt.counter < 2) {
				Movement.getInstance().turn_right(90);
			} 
			else {
				Movement.getInstance().turn_left(90);
			}
			rt.counter++;
		}
			
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
