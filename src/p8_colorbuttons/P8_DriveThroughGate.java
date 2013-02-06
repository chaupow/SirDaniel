package p8_colorbuttons;

import general.Movement;
import general.SensorCache;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P8_DriveThroughGate implements Behavior{
	Movement movement = Movement.getInstance();
	SensorCache sc = SensorCache.getInstance();
	boolean suppressed;
	ColorButtons cb;
	
	public P8_DriveThroughGate(ColorButtons cb) {
		this.cb = cb;
	}
	
	@Override
	public boolean takeControl() {
		return sc.bumperPressed;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.backward();
		while (!suppressed && !sc.backPressed){
			Thread.yield();
		}
		movement.stop();
		Button.waitForAnyPress();
		if (!suppressed) {
			movement.turn_left(90);
		}
		Button.waitForAnyPress();
		movement.travel(600);
		while (!suppressed){
			Thread.yield();
		}
		movement.stop();
		cb.gate.disconnectFromGate();
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
