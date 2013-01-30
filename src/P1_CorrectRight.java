import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P1_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int shouldBe; // i.e. 10
	boolean suppressed;

	public P1_CorrectRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int shouldBe) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.shouldBe = shouldBe;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > shouldBe);
	}
	
	public void action() {
		suppressed = false;
		Movement.turn_right(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}

