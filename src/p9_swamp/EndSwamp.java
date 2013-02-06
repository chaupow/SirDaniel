package p9_swamp;

import general.ClaudisMain;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class EndSwamp implements Behavior{

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return (SensorCache.getInstance().lightValue > Settings.LIGHT_THRESHOLD);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("Swamp beendet");
		ClaudisMain.searchBarcode();		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
