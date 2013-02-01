package p1_labyrinth;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;


public class P1_CorrectLeft implements Behavior {
	Movement movement = Movement.getInstance();
	
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
		return (sonic.getDistance() < min_dist);
	}
	
	public void action() {
		suppressed = false;
		movement.setRotationSpeed(rotationSpeed);
		
		LCD.drawString("Correct Left", 1, 1);
		movement.arc(-6.0, 5.0, true);
		//movement.turn_left(5);
	}
	
	public void suppress() {
		suppressed = true;
	}
	

	

}
