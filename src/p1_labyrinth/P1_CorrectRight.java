package p1_labyrinth;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import general.Movement;
import lejos.robotics.subsumption.Behavior;


public class P1_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int max_dist;
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public P1_CorrectRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int max_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.max_dist = max_dist;
		movement.setRotationSpeed(rotationSpeed);

	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > max_dist);
	}
	
	public void action() {
		suppressed = false;
		
		LCD.drawString("Correct Right", 1, 1);
		//movement.turn_right(5);
		//movement.arc(-30, -5, true);
		movement.steer(-30, -5, true);
		/*while(!suppressed) {
			Thread.yield();
		}*/
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	


}

