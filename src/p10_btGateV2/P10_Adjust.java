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
		int distance = sonar.getDistance() - TURN_DISTANCE;
		while (!suppressed) {
			if (distance > INFINITY) {
				System.out.println("infinity");
				Movement.getInstance().setTravelSpeed(100);
				Movement.getInstance().forward();
			} else {
				if (distance < 0) {
					System.out.println("> distanz");
//					while (!Motor.C.isMoving() && !suppressed) {
//						Movement.getInstance().steer(-25, -5, true);
						Movement.getInstance().steer(25, -2*distance, true);
//					}
				} else {
					System.out.println("< distanz");
//					while (!Motor.C.isMoving() && !suppressed) {
//						Movement.getInstance().steer(25, 5, true);
						Movement.getInstance().steer(-25, -2*distance, true);
//					}
				}
			}
		}
		
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
