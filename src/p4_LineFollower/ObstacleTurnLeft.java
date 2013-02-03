package p4_LineFollower;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import general.Calibration;
import general.Movement;
import general.SensorCache;


public class ObstacleTurnLeft implements Behavior {
	
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public ObstacleTurnLeft() {
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
	}
	
	public boolean takeControl() {
		return (SensorCache.getInstance().bumperPressed && SensorCache.getInstance().normalizedLightValue < Calibration.THRESHOLD) && Config.foundObstacle;
	}
	
	public void action() {
		suppressed = false;
		movement.setTravelSpeed(100);

		movement.arcBackward(-40);
		//movement.steerBackward(-40);
		
		movement.turn_left(90);
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
