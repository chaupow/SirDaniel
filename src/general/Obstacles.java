package general;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Movement;

// behavior for recognizing and avoiding obstacles
public class Obstacles implements Behavior {
	Movement movement = Movement.getInstance();
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int min_dist; // i.e. 10
	float metersPerUnit = 0.01f;
	float valuesPerSecond = 13.3f;
	int max_Values = 10;
	float threshold = 
	boolean suppressed;

	public Obstacles(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist) {
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
		movement.setTravelSpeed(speed);		
		LCD.drawString("Obstacle", 1, 1);
		
		float obstacleVelocity = calculateVelocity() - movement.getVelocity();
		if (obstacleVelocity < 0) {
			// means there is another robot driving towards us
			// do a left turn
			movement.turn_left(90);
			movement.forward();
			Delay.msDelay(200);
			movement.turn_right(90);		
		} else if (obstacleVelocity == 0) {
			// means the obstacle is not moving
			movement.steer(-50, -180, true);
		} else {
			// means there is a robot driving in front of us
			if (obstacleVelocity < threshold) {
				
			}
		}
	
		
		movement.arc(-6.0, 5.0, true);
		//movement.turn_left(5);
	}
	
	public float calculateVelocity() {
		/* sonicValues should contain the last max_Values sonic values
		 * [0] should be the newest value, [max_Values - 1] should be the oldest
		 * value.
		 * How often do the values get recorded? 100 per s? => valuesPerSecond
		 * How many meters equal 1 unit of sonic value? 0.01 m/s? => metersPerUnit
		 */
		/* between two values, we can calculate the difference in sonic units*/
		int valueDifference;
		/* From the difference we can calculate the velocity relative to the 
		 * object in front of us 
		 */
		float velocity;
		/* then we calculate the average over the last max_Values entries to minimize
		 * measurement errors.
		 */
		float averageVelocity;
		for (int i = 0; i < max_Values; i++) {
			/* sonicValues will be filled with maxValues sonic values */
			sonic.getDistances(sonicValues, 0, maxValues);
			valueDifference = sonicValues[i] - sonicValues[i + 1]; 
			/* metersPerUnit and valuesPerSecond need to be defined either 
			 * locally or globally. Might be useful in other classes as well. 
			 */
			velocity = valueDifference * metersPerUnit / valuesPerSecond;
			averageVelocity = (averageVelocity + velocity) / 2;
		}
		return averageVelocity;
	}
	
	public void suppress() {
		suppressed = true;
	}
	

	

}
