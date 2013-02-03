package p4_LineFollower;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior{

	@Override
	public boolean takeControl() {
		return Config.foundEnd;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("MUHAHAHAHAH", 1, 1);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		LCD.clear();
	}

}
