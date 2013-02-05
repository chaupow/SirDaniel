package p6_slider;

import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;
import general.Settings;

public class P6_PushButton implements Behavior {
	
	
	private boolean front;
	
	@Override
	public boolean takeControl() {
		front = SensorCache.getInstance().bumperPressed;
		return (front && SensorCache.getInstance().normalizedLightValue < 20);
		
		}

	@Override
	public void action() {		
		
		if (front) {
			
			Movement.getInstance().turn_left(90);
			Config.NumberOfTurns++;
			
		} 
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}
