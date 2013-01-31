import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P1_TurnLeft implements Behavior {
	
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	boolean suppressed;
	Movement movement = new Movement();

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
		movement.backward(speed);
		Delay.msDelay(1000);
		movement.turn_left(90, rotationSpeed);
		movement.forward(speed);
		Delay.msDelay(1000);
		movement.stop();
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
