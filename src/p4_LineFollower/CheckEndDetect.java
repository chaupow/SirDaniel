package p4_LineFollower;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class CheckEndDetect implements Behavior{
	int trigger;

	public CheckEndDetect(int trigger) {
		this.trigger = trigger;
	}
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches == trigger;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("CheckEndDetect", 1, 1);
		Config.isCheckingEnd = true;
	}

	@Override
	public void suppress() {
		
	}

}
