import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P1_TurnLeft implements Behavior {
	
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public P1_TurnLeft( TouchSensor touch, int speed, int rotationSpeed) {
		this.touch = touch;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
	}
	
	public boolean takeControl() {
		return (touch.isPressed());
	}
	
	public void action() {
		suppressed = false;
		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);

		movement.backward();
		Delay.msDelay(1000);
		
		movement.turn_left(90);		
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
