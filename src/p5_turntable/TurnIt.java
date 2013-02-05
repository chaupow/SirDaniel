package p5_turntable;

import bluetooth.TurnControl;
import general.SensorCache;
import general.Settings;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class TurnIt implements Behavior {
	
	// ideally this is a divisor of 120;
	public final int STEPS = 15;
	public final int turnAngle = 115/STEPS;
	
	TurnControl turntableControl = new TurnControl();

	@Override
	public boolean takeControl() {
		return true;
		//return Config.hasTurned && !Config.hasAdjusted;
	}

	@Override
	public void action() {
		
		while (!turntableControl.connectionToTurntableSuccessful());
		for (int i = 0; i < STEPS; i++) {
			turntableControl.turnClockwise(turnAngle);
		}
		Button.waitForAnyPress();
		turntableControl.disconnectFromTurntable();
		
		Config.hasAdjusted = true;
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
