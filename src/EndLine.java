import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class EndLine implements Behavior{

	@Override
	public boolean takeControl() {
		return LineFollower.finishedSearch;
	}

	@Override
	public void action() {
		Movement.forward(2);
		Delay.msDelay(2000);
		Movement.stop();
	}

	@Override
	public void suppress() {
	}

}
