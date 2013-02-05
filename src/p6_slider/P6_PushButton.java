package p6_slider;

import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;
import general.Settings;

public class P6_PushButton implements Behavior {
	
	// set the interval. 
	
	// make sure he doesn't stall at the beginning
	
	private boolean back;
	private boolean front;
	
	@Override
	public boolean takeControl() {
		back = SensorCache.getInstance().backPressed;
		front = SensorCache.getInstance().bumperPressed;
		return ((front || back) && SensorCache.getInstance().normalizedLightValue < 250);
		
			}

	@Override
	public void action() {		
		
		if (front) {
			
			if (!back){
				Movement.getInstance().turn_left(90);
				Config.NumberOfTurns++;
			}
		} else {
			if (Config.NumberOfTurns >= 2) {
				general.Movement.getInstance().setTravelSpeed(300);
				//TODO reicht das so, auch wenn man am Schieber haegen bleibt?
				Movement.getInstance().travel(2000, true);
	
			}
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}
