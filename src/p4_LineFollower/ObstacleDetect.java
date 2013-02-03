package p4_LineFollower;

import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class ObstacleDetect implements Behavior{
	
	public ObstacleDetect () {
		//this.sensorCache = sensorCache;
	}

	@Override
	public boolean takeControl() {
		SensorCache sensorCache = SensorCache.getInstance();
		return sensorCache.bumperPressed;
	}

	@Override
	public void action() {
		Config.foundObstacle = true;
	}

	@Override
	public void suppress() {
		
	}

}
