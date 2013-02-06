package p9_btGate;

import general.ClaudisMain;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class P9_EndGate implements Behavior {

	@Override
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue > Settings.LIGHT_THRESHOLD);
	}

	@Override
	public void action() {
		System.out.println("Gate Ende");
		ClaudisMain.searchBarcode();
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
