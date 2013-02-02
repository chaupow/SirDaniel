package p1_labyrinth;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;


public class P1_TurnLeft implements Behavior {
	
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public P1_TurnLeft(int speed, int rotationSpeed) {
		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);
	}
	
	public boolean takeControl() {
		return SensorCache.getInstance().bumperPressed;
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
