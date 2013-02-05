package p6_slider;

import general.Movement;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class P6_travelBackwards implements Behavior {
	
	boolean suppressed = false;;

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return (Config.NumberOfTurns == 2);
	}

	@Override
	public void action() {
		//Fahre rueckwaerts
		suppressed = false;
		Movement.getInstance().backward();
		
		while (!suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	
	

}
