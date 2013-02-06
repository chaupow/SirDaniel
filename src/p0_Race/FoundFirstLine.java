package p0_Race;

import general.ClaudisMain;
import general.Movement;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class FoundFirstLine implements Behavior {
	

	@Override
	public boolean takeControl() {
		// first stripe of barcode detected
		return (SensorCache.getInstance().lightValue > Settings.LIGHT_THRESHOLD && !Constants.foundFirstLine);
	}

	@Override
	public void action() {
		Movement movement = Movement.getInstance();
		movement.travel(10);
		Constants.foundFirstLine = true;
	}

	@Override
	public void suppress() {
		
	}

}
