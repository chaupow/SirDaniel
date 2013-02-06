package p8_colorbuttons;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class P8_BOSS implements Behavior{
	ColorButtons cb;
	Movement movement = Movement.getInstance();
	SensorCache sc = SensorCache.getInstance();
	
	public void Behavior (ColorButtons cb) {
		this.cb = cb;
	}

	@Override
	public boolean takeControl() {
		return cb.boss;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Boss", 1, 1);
		movement.setTravelSpeed(movement.getMaxTravelSpeed());
		movement.setRotateSpeed(movement.getMaxRotateSpeed());
		while(true) {
			if (sc.bumperPressed) {
				movement.stop();
				movement.turn_left(90);
				while(movement.isMoving());
				movement.forward();
			}
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
