package p6_slider;

import general.Movement;
import general.SensorCache;
import general.Settings;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class P6_Slider implements Behavior {
	
	boolean suppressed = false;;

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return (Config.NumberOfTurns == 2 && SensorCache.getInstance().bumperPressed);
	}

	@Override
	public void action() {
		//Fahre rueckwaerts
		suppressed = false;

		while (SensorCache.getInstance().bumperPressed);
		Movement.getInstance().forward();
		
		while (!suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	
	

}
