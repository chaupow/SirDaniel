package p1_labyrinth;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;


public class P1_TurnLeft implements Behavior {
	
	TouchSensor touch;
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public P1_TurnLeft( TouchSensor touch, int speed, int rotationSpeed) {
		this.touch = touch;

		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);
	}
	
	public boolean takeControl() {
		return (touch.isPressed());
	}
	
	public void action() {
		suppressed = false;
		
		movement.steerBackward(-200);
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
