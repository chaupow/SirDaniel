package p6_slider;

import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;

public class P6_PushButton implements Behavior {
	
	
	private boolean front;
	
	@Override
	public boolean takeControl() {
		front = SensorCache.getInstance().bumperPressed;
		return (front && SensorCache.getInstance().lightValue < 20);
		
		}

	@Override
	public void action() {		
		
		if (front) {
			
			if(Config.NumberOfTurns < 2) {

				Movement.getInstance().turn_left(110);
				Config.NumberOfTurns++;
			} else {
				Movement.getInstance().travel(-20);
			}
			
			
			
		} 
		
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}
