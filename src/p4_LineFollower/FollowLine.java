package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {
	Movement movement;
	int threshold;
	boolean suppressed;
	
	
	public FollowLine() {
		this.movement = Movement.getInstance();
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = SensorCache.getInstance().normalizedLightValue;
		return (lightvalue >= threshold)  && !Config.foundEnd;
	}
	
	@Override
	public void action() {
		Config.random = false;
		Config.finishedSearch = false;
		Config.numberOfSearches = 0;
		Config.foundObstacle = false;
		suppressed = false;
		LCD.clear();
		LCD.drawString("FollowLine", 1, 1);
		movement.setTravelSpeed(150);
		movement.setRotateSpeed(150);
		movement.stop();
		while(!suppressed && (SensorCache.getInstance().normalizedLightValue >= threshold)) {
			movement.travel(10, true);
			LCD.drawString(""+SensorCache.getInstance().normalizedLightValue, 1, 2);
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
