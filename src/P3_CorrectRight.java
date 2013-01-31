import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int max_dist;
	boolean suppressed;
	LightSensor light;

	public P3_CorrectRight(UltrasonicSensor sonic, int speed, int rotationSpeed, int max_dist, LightSensor light) {
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.max_dist = max_dist;
		this.light = light;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() >= max_dist) && light.getNormalizedLightValue() < P3_Behavior.threshold;
	}
	
	public void action() {
		suppressed = false;
		Movement.turn_right(5, rotationSpeed);
	}
	
	public void suppress() {
		suppressed = true;
	}
	


}

