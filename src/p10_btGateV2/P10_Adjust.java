package p10_btGateV2;

import general.Movement;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P10_Adjust implements Behavior {
	
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
	private static boolean hasAdjusted = false;
	
	private static final int TURN_DISTANCE = 10;

	@Override
	public boolean takeControl() {
		return !hasAdjusted;
	}

	@Override
	public void action() {
		hasAdjusted = true;
		
		int distance = sonar.getDistance();
		
		if (distance > TURN_DISTANCE) {
			Movement.getInstance().steer(-30, -5, true);
		} else {
			Movement.getInstance().steer(30, 5, true);
		}
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
