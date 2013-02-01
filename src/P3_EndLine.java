import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_EndLine implements Behavior{
	Movement movement;
	
	public P3_EndLine() {
		this.movement = Movement.getInstance();
	}
		
	@Override
	public boolean takeControl() {
		return (P3.end && !P3.stop);
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("End Line", 1, 1);
		
		movement.setSpeed(2);
		movement.forward();
		Delay.msDelay(2000);
		movement.stop();
		P3.stop = true;
	}

	@Override
	public void suppress() {
	}

}
