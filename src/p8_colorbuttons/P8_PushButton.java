package p8_colorbuttons;

import general.Movement;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class P8_PushButton implements Behavior{
	ColorButtons cb;
	Movement movement = Movement.getInstance();
	boolean suppressed;
	
	public P8_PushButton (ColorButtons cb) {
		this.cb = cb;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return cb.blackLines == 3;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Push Button", 1, 1);
		suppressed = false;
		SuperMotor.turnTo(180, true);
		
		movement.turn_right(70);
		movement.forward();
		while (!suppressed) {
			Thread.yield();
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
