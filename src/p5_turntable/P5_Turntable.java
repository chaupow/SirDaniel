package p5_turntable;

import bluetooth.TurnControl;
import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class P5_Turntable implements Behavior {
	
	// ideally this is a divisor of 120;
	private static final int STEPS = 15;
	private static final int turnAngle = 120/STEPS;

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		
		TurnControl turntableControl = new TurnControl();
		
		Movement.getInstance().setTravelSpeed(75);
		Movement.getInstance().forward();
		
		while (!SensorCache.getInstance().bumperPressed);
		
		Movement.getInstance().travel(-30);
		Movement.getInstance().turn_left(160);
		
		while (!turntableControl.connectionToTurntableSuccessful());
		for (int i = 0; i < STEPS; i++) {
			turntableControl.turnClockwise(turnAngle);
		}
		
		// wait for the turntable to turn.
		System.out.println("Waiting 10s.");
		Delay.msDelay(20000);
		
		Movement.getInstance().travel(75);
		
		P5.getInstance().stop();
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
