import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P1_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int min_dist;
	int max_dist;
	boolean suppressed;

	public P1_CorrectRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist, int max_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.min_dist = min_dist;
		this.max_dist = max_dist;
	}
	
	public boolean takeControl() {
		return (isInRange(sonic.getDistance()));
	}
	
	public void action() {
		suppressed = false;
		Movement.turn_right(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	private boolean isInRange(int dist){
		
		return (dist < max_dist && dist >= min_dist);
	}
	

}

