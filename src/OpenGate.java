import lejos.robotics.subsumption.*;

public class OpenGate implements Behavior {
	private boolean inFrontOfDoor = false;
	private GateControl gate = new GateControl();

	@Override
	public boolean takeControl() {
		return inFrontOfDoor;
	}

	@Override
	public void action() {
		while (!gate.connectionToGateSuccessful(GateCommon.GATE_3));
		gate.openGate();
		gate.disconnectFromGate();
	}

	@Override
	public void suppress() {
	
	}
	
}
