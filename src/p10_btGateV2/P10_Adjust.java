package p10_btGateV2;

import general.Movement;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P10_Adjust implements Behavior {
	
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
	
	private static final int TURN_DISTANCE = 10;
	private static final int INFINITY = 30;
	boolean suppressed = false;

	@Override
	public boolean takeControl() {
		return Config.gateHasOpened;
	}

	@Override
	public void action() {
		System.out.println("adjust");
		Movement.getInstance().forward();
		while (!suppressed) {
			Thread.yield();
		}
		
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
