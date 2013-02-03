package p4_LineFollower;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;


public class ObstacleTurnRight implements Behavior {
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	int shouldBe; // i.e. 10
	int minimumDifference; // i.e. 20 (--> reacts at value 10 + 20 = 30)
	boolean suppressed;
	Movement movement = Movement.getInstance();
	

	public ObstacleTurnRight(UltrasonicSensor sonic, int shouldBe, int minimumDifference) {
		this.sonic = sonic;
		this.shouldBe = shouldBe;
		this.minimumDifference = minimumDifference;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !SensorCache.getInstance().bumperPressed) && Config.foundObstacle;
	}
	
	public void action() {
		suppressed = false;
		//movement.setSpeed(speed);
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);

		LCD.drawString("steering" , 1, 1);
		movement.arcForward(-60);
		
				
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
