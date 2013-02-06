package p8_colorbuttons;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SensorCache;

public class Lab_TurnLeft implements Behavior {
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	int shouldBe; // i.e. 10
	int minimumDifference; // i.e. 20 (--> reacts at value 10 + 20 = 30)
	boolean suppressed;
	Movement movement = Movement.getInstance();
	ColorButtons cb;
	

	public Lab_TurnLeft(UltrasonicSensor sonic, int speed, int rotationSpeed, int shouldBe, int minimumDifference, ColorButtons cb) {
		this.sonic = sonic;
		movement.setRotationSpeed(rotationSpeed);
		this.shouldBe = shouldBe;
		this.minimumDifference = minimumDifference;
		this.cb = cb;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !SensorCache.getInstance().bumperPressed && cb.lab);
	}
	
	public void action() {
		suppressed = false;
		//movement.setSpeed(speed);

		LCD.drawString("steering" , 1, 1);
		Movement.getInstance().arc(80, 180, true);
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
