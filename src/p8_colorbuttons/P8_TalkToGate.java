package p8_colorbuttons;


import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P8_TalkToGate implements Behavior{
	ColorGateControl gate;
	ColorButtons cb;
	
	public P8_TalkToGate(ColorButtons cb, ColorGateControl gate) {
		this.cb = cb;
		this.gate = gate;
	}

	@Override
	public boolean takeControl() {
		return cb.requestedColor == -1;
	}

	@Override
	public void action() {
		while (!gate.connectionToColorGateSuccessful());
		// 0-green, 1-yellow, 2-red
		cb.requestedColor = gate.readColor();
		System.out.println(cb.requestedColor);
	}

	@Override
	public void suppress() {
		
	}

}
