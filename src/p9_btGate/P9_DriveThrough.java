package p9_btGate;

import general.Movement;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P9_DriveThrough implements Behavior{
	UltrasonicSensor sonic;
	int distanceThreshold;
	boolean suppressed;
	Movement movement = Movement.getInstance();
	P9 gate;

	public P9_DriveThrough(UltrasonicSensor sonic, int distanceThreshold, P9 gate) {
		this.sonic = sonic;
		this.distanceThreshold = distanceThreshold;
		this.gate = gate;
	}
	
	@Override
	public boolean takeControl() {
		return sonic.getDistance() >= distanceThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.forward();
		while (!suppressed && sonic.getDistance() >= distanceThreshold) {
			Thread.yield();
		}
		movement.stop();
		gate.inFrontOfGate = true;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
