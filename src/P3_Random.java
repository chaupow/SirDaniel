import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;


public class P3_Random implements Behavior{
	boolean suppressed;
	Movement movement = new Movement();

	@Override
	public boolean takeControl() {
		return !P3.end && (P3.numberOfSearches == 3);
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.clear();
		LCD.drawString("Random", 1, 1);
		movement.forward(1);
		while (!suppressed)
			Thread.yield();
		movement.stop();
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
