package p10_btGate;

import general.Movement;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P10_DriveThrough implements Behavior{
	UltrasonicSensor sonic;
	int distanceThreshold;
	boolean suppressed;
	Movement movement = Movement.getInstance();
	P10 gate;

	public P10_DriveThrough(UltrasonicSensor sonic, int distanceThreshold, P10 gate) {
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
