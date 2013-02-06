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

	@Override
	public boolean takeControl() {
		return Config.gateHasOpened;
	}

	@Override
	public void action() {
		System.out.println("adjust");
		
		int distance = sonar.getDistance();
		
		if (distance > INFINITY) {
			Movement.getInstance().setTravelSpeed(100);
			Movement.getInstance().forward();
		} else {
			if (distance > TURN_DISTANCE) {
				while (!Motor.C.isMoving()) {
					Movement.getInstance().steer(-30, -5, true);
				}
			} else {
				while (!Motor.C.isMoving()) {
					Movement.getInstance().steer(30, 5, true);
				}
			}
		}
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
