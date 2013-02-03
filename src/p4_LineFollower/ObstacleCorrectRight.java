package p4_LineFollower;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import general.Movement;
import lejos.robotics.subsumption.Behavior;


public class ObstacleCorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int max_dist;
	boolean suppressed;
	Movement movement = Movement.getInstance();

	public ObstacleCorrectRight(UltrasonicSensor sonic, int max_dist) {
		this.sonic = sonic;
		this.speed = speed;
		this.max_dist = max_dist;
		movement.setRotateSpeed(100);

	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > max_dist) && Config.foundObstacle;
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

