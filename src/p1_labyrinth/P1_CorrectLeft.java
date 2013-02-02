package p1_labyrinth;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;


public class P1_CorrectLeft implements Behavior {
	Movement movement = Movement.getInstance();
	
	UltrasonicSensor sonic;
	int speed;
	int min_dist; // i.e. 10
	boolean suppressed;

	public P1_CorrectLeft(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.min_dist = min_dist;
		movement.setRotationSpeed(rotationSpeed);

	}
	
	public boolean takeControl() {
		return (sonic.getDistance() < min_dist);
	}
	
	public void action() {
		suppressed = false;
		movement.setTravelSpeed(100);

		LCD.drawString("Correct Left", 1, 1);
		movement.steer(30, 5, true);
		//movement.arc(30.0, 5.0, true);
		//movement.turn_left(5);
	}
	
	public void suppress() {
		suppressed = true;
	}
	

	

}
