package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class ObstacleDetect implements Behavior{
	Movement movement = Movement.getInstance();
	
	public ObstacleDetect () {
		//this.sensorCache = sensorCache;
	}

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed;
	}

	@Override
	public void action() {
		movement.rotate(90, false);
		// TODO SuperMotor nach rechts drehen
		Config.foundObstacle = true;
	}

	@Override
	public void suppress() {
		
	}

}
