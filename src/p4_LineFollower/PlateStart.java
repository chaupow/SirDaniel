package p4_LineFollower;

import general.Movement;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class PlateStart implements Behavior {
	int threshold;
	LightSensor light;
	Movement movement;
	boolean suppressed;

	public PlateStart(LightSensor light){
		this.light = light;
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return !Config.lineFoundOnce && light.getNormalizedLightValue() < Config.lightThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.setSpeed(1);
		movement.forward();
		while (!suppressed) {
			Thread.yield();
		} 
		movement.stop();
		movement.turn_right(30);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
