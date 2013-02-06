package p0_Race;

import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;


public class P0_TurnRight implements Behavior {
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	int shouldBe; // i.e. 10
	int minimumDifference; // i.e. 20 (--> reacts at value 10 + 20 = 30)
	boolean suppressed;
	Movement movement = Movement.getInstance();
	

	public P0_TurnRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int shouldBe, int minimumDifference) {
		this.sonic = sonic;
		movement.setSpeed(speed);
		movement.setRotationSpeed(rotationSpeed);
		this.shouldBe = shouldBe;
		this.minimumDifference = minimumDifference;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !SensorCache.getInstance().bumperPressed);
	}
	
	public void action() {
		suppressed = false;
		
		LCD.clear();
		LCD.drawString("dist: " + sonic.getDistance(), 0, 4);
		LCD.drawString("steering" , 0, 1);
		movement.arcForward(-60);
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
