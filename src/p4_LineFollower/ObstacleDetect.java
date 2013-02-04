package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class ObstacleDetect implements Behavior{
	Movement movement = Movement.getInstance();
	UltrasonicSensor sonic;
	boolean suppressed;
	
	public ObstacleDetect (UltrasonicSensor sonic) {
		this.sonic = sonic;
	}

	@Override
	public boolean takeControl() {
		return sonic.getDistance() < Config.sonicThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		System.out.println("Obstacle");
//		movement.rotate(-90, false);
//		SuperMotor.turnTo(180, false);
//		movement.travel(20);
		movement.arc(-300, 1, true);
		Config.foundObstacle = true;
		while(!suppressed)
			Thread.yield();
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
