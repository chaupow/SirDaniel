package bluetooth;
import lejos.robotics.subsumption.Behavior;

public class OpenGate implements Behavior {
	BluetoothGate blgate;
	private GateControl gate = new GateControl();

	public OpenGate(BluetoothGate gate) {
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
