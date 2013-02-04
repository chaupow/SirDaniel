package p3_LineFollowerDeprecated;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import general.Movement;

public class P3_Random implements Behavior{
	boolean suppressed;
	Movement movement;

	public P3_Random() {
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return !P3.end && (P3.numberOfSearches == 3);
	}

	@Override
	public void action() {
		suppressed = false;
		
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Random", 1, 1);
		
		movement.setSpeed(1);
		movement.forward();
		while (!suppressed)
			Thread.yield();
		movement.stop();
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
