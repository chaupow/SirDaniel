package p4_LineFollower;

import general.Movement;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class FollowLine implements Behavior {
	Movement movement;
	LightSensor light;
	int threshold;
	boolean suppressed;
	
	public FollowLine(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue();
		return (lightvalue >= threshold);
	}
	
	@Override
	public void action() {
		Config.random = false;
		Config.numberOfSearches = 0;
		suppressed = false;
		movement.setSpeed(2);
		movement.forward();
		while(!suppressed) {
			Thread.yield();
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
