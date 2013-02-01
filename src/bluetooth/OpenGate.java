package bluetooth;
import lejos.robotics.subsumption.Behavior;

public class OpenGate implements Behavior {
	private boolean inFrontOfDoor = true;
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
		inFrontOfDoor = false;
	}

	@Override
	public void suppress() {
	
	}
	
}
