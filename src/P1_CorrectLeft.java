import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P1_CorrectLeft implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int min_dist; // i.e. 10
	int max_dist;
	boolean suppressed;

	public P1_CorrectLeft(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist, int max_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.min_dist = min_dist;
	}
	
	public boolean takeControl() {
		return (isInRange(sonic.getDistance()));
	}
	
	public void action() {
		suppressed = false;
		Movement.turn_left(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	private boolean isInRange(int dist){
		
		return (dist < max_dist && dist >= min_dist);
	}
	

}
