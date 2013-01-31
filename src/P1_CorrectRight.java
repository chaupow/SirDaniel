import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class P1_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int max_dist;
	boolean suppressed;
	Movement movement = new Movement();

	public P1_CorrectRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int max_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.max_dist = max_dist;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() >= max_dist);
	}
	
	public void action() {
		suppressed = false;
		movement.turn_right(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	


}

