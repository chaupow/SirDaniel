import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_TurnLeft implements Behavior {
	Movement movement;
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	boolean suppressed;

	public P3_TurnLeft( TouchSensor touch, int speed, int rotationSpeed, Movement movement) {
		this.movement = movement;
		this.touch = touch;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
	}
	
	public boolean takeControl() {
		return (touch.isPressed());
	}
	
	public void action() {
		movement.turn_left(90, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
