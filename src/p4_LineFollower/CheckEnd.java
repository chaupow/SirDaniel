package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class CheckEnd implements Behavior{
	Movement movement = Movement.getInstance();
	boolean suppressed;
	int trigger;
	
	public CheckEnd(int trigger){
		this.trigger = trigger;
	}
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches == trigger;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.clear();
		LCD.drawString("CheckEnd", 1, 1);
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		movement.travel(-80, true);
		while (!suppressed && movement.isMoving() && SensorCache.getInstance().normalizedLightValue <= Config.lightThreshold) {Thread.yield();}
		movement.stop();
		if (SensorCache.getInstance().normalizedLightValue >= Config.lightThreshold){
			Config.foundEnd = true;
		}
		else {
			Config.isCheckingEnd = false;
			Config.finishedSearch = false;	
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
