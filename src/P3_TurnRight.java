import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_TurnRight implements Behavior {
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	int shouldBe; // i.e. 10
	int minimumDifference; // i.e. 20 (--> reacts at value 10 + 20 = 30)
	boolean suppressed;
	LightSensor light;

	public P3_TurnRight(UltrasonicSensor sonic, TouchSensor touch, int speed, int rotationSpeed, int shouldBe, int minimumDifference, LightSensor light) {
		this.sonic = sonic;
		this.touch = touch;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.shouldBe = shouldBe;
		this.minimumDifference = minimumDifference;
		this.light = light;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !touch.isPressed()) && light.getNormalizedLightValue() < P3_Behavior.threshold;
	}
	
	public void action() {
		suppressed = false;
		Movement.forward(speed);
		Delay.msDelay(1000);
		Movement.turn_right(90, rotationSpeed);
		Movement.forward(speed);
		Delay.msDelay(1000);
		Movement.stop();
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
