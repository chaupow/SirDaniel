package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class ObstacleQuit implements Behavior{
	Movement movement = Movement.getInstance();

	@Override
	public boolean takeControl() {
		return Config.foundObstacle && SensorCache.getInstance().normalizedLightValue >= Config.lightThreshold;
	}

	@Override
	public void action() {
		movement.rotate(90, false);
		// TODO Super Motor nach vorne
		Config.foundObstacle = false;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
