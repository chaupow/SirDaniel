package p1_labyrinth;
import lejos.nxt.UltrasonicSensor;
import general.Movement;
import lejos.robotics.subsumption.Behavior;


public class P1_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int max_dist;
	boolean suppressed;
	Movement movement = Movement.getInstance();

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
		movement.setRotationSpeed(rotationSpeed);
		movement.turn_right(5);
	}
	
	public void suppress() {
		suppressed = true;
	}
	


}

