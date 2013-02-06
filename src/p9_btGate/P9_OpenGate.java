package p9_btGate;

import bluetooth.GateCommon;
import bluetooth.GateControl;
import lejos.robotics.subsumption.Behavior;

public class P9_OpenGate implements Behavior {
	P9 blgate;
	private GateControl gate = new GateControl();

	public P9_OpenGate(P9 gate) {
		this.blgate = gate;
	}
	
	@Override
	public boolean takeControl() {
		return blgate.inFrontOfGate;
	}

	@Override
	public void action() {
		while (!gate.connectionToGateSuccessful(GateCommon.GATE_3));
		gate.openGate();
		gate.disconnectFromGate();
		blgate.inFrontOfGate = false;
	}

	@Override
	public void suppress() {
	
	}
	
}
