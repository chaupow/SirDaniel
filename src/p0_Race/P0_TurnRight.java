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
	

	public P0_TurnRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int shouldBe, int minimumDifference) {
		this.sonic = sonic;
		this.shouldBe = shouldBe;
		Movement.getInstance().setSpeed(speed);
		Movement.getInstance().setRotationSpeed(rotationSpeed);
		this.minimumDifference = minimumDifference;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !SensorCache.getInstance().bumperPressed);
	}
	
	public void action() {
		suppressed = false;
		
		LCD.drawString("dist: " + sonic.getDistance(), 0, 4);
		LCD.drawString("steering" , 0, 2);
		//movement.arcForward(-60);
		//Movement.getInstance().turn_right(70);
		Movement.getInstance().arc(-80, -180, true);
		
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
