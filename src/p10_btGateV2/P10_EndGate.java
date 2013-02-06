package p10_btGateV2;
import general.ClaudisMain;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class P10_EndGate implements Behavior {

	@Override
	public boolean takeControl() {
		return (SensorCache.getInstance().lightValue > Settings.LIGHT_THRESHOLD && Config.gateHasOpened);
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
