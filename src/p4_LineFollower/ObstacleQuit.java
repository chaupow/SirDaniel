package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.robotics.subsumption.Behavior;

public class ObstacleQuit implements Behavior{
	Movement movement = Movement.getInstance();
	SuperMotor supmoto = new SuperMotor();

	@Override
	public boolean takeControl() {
		return Config.foundObstacle && SensorCache.getInstance().normalizedLightValue >= Config.lightThreshold;
	}

	@Override
	public void action() {
		movement.rotate(90, false);
		// TODO Super Motor nach vorne
		supmoto.turnTo(90, false);
		Config.foundObstacle = false;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
