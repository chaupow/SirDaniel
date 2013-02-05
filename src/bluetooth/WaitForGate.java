package bluetooth;
import lejos.robotics.subsumption.Behavior;

public class WaitForGate implements Behavior{
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
