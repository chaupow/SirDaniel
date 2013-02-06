package p10_btGate;

import bluetooth.GateCommon;
import bluetooth.GateControl;
import lejos.robotics.subsumption.Behavior;

public class P10_OpenGate implements Behavior {
	P10 blgate;
	private GateControl gate = new GateControl();

	public P10_OpenGate(P10 gate) {
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
