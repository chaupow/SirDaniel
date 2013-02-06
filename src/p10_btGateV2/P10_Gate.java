package p10_btGateV2;

import bluetooth.GateCommon;
import bluetooth.GateControl;
import lejos.robotics.subsumption.Behavior;

public class P10_Gate implements Behavior {

	@Override
	public boolean takeControl() {
		return !Config.gateHasOpened;
	}

	@Override
	public void action() {
		GateControl gate = new GateControl();
		
		while (!gate.connectionToGateSuccessful(GateCommon.GATE_3));
		gate.openGate();
		gate.disconnectFromGate();
		
		Config.gateHasOpened = true;
		System.out.println("lala");
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}
