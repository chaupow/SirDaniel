package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class ObstacleDetect implements Behavior{
	//SuperMotor supmoto = SuperMotor.getInstance();
	Movement movement = Movement.getInstance();
	UltrasonicSensor sonic;
	
	public ObstacleDetect (UltrasonicSensor sonic) {
		this.sonic = sonic;
	}

	@Override
	public boolean takeControl() {
		return sonic.getDistance() < Config.sonicThreshold;
	}

	@Override
	public void action() {
		System.out.println("Obstacle");
		movement.rotate(-90, false);
		SuperMotor.turnTo(180, false);
		Config.foundObstacle = true;
	}

	@Override
	public void suppress() {
		
	}

}
