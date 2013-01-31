import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;


public class P1_CorrectLeft implements Behavior {
	Movement movement = new Movement();
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int min_dist; // i.e. 10
	boolean suppressed;

	public P1_CorrectLeft(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.min_dist = min_dist;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() <= min_dist);
	}
	
	public void action() {
		suppressed = false;
		movement.turn_left(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	

	

}
