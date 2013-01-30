import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3EndLine implements Behavior{

	@Override
	public boolean takeControl() {
		return P3.end;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("End Line", 1, 1);
		Movement.forward(2);
		Delay.msDelay(2000);
		Movement.stop();
	}

	@Override
	public void suppress() {
	}

}
