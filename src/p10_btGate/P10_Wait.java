package p10_btGate;
import lejos.robotics.subsumption.Behavior;

public class P10_Wait implements Behavior{
	boolean suppressed;
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		suppressed = false;
		while (!suppressed) {
			Thread.yield();
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
