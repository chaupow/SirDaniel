package p8_colorbuttons;

import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class Lab_Disconnect implements Behavior{
	ColorButtons cb;
	
	public Lab_Disconnect (ColorButtons cb) {
		this.cb = cb;
	} 

	@Override
	public boolean takeControl() {
		return cb.lab && SensorCache.getInstance().lightValue > Settings.LIGHT_THRESHOLD && !cb.disconnected;
	}

	@Override
	public void action() {
		cb.gate.disconnectFromGate();
		cb.disconnected = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
