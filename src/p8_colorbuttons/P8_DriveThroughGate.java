package p8_colorbuttons;

import general.Movement;
import general.SensorCache;
import lejos.nxt.Button;
import lejos.nxt.LCD;
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
		return sc.backPressed;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Drive Through", 1, 1);
		suppressed = false;
		movement.forward();
		while (!suppressed && !sc.bumperPressed){
			Thread.yield();
		}
		movement.stop();
		if (!suppressed)movement.travel(-70);
		if (!suppressed) {
			movement.turn_right(80);
		}
		movement.setTravelSpeed(300);
		movement.setRotateSpeed(300);
		cb.lab = true;
		
		//cb.gate.disconnectFromGate();
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
