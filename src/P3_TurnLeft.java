import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_TurnLeft implements Behavior {
	
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	boolean suppressed;

	public P3_TurnLeft( TouchSensor touch, int speed, int rotationSpeed) {
		this.touch = touch;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
	}
	
	public boolean takeControl() {
		return (touch.isPressed());
	}
	
	public void action() {
		suppressed = false;
		Movement.backward(speed);
		Delay.msDelay(1000);
		Movement.turn_left(90, rotationSpeed);
		Movement.forward(speed);
		Delay.msDelay(1000);
		Movement.stop();
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
