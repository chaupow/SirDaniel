import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_CorrectLeft implements Behavior {
	
	UltrasonicSensor sonic;
	int speed;
	int rotationSpeed;
	int min_dist; // i.e. 10
	boolean suppressed;
	LightSensor light;
	Movement movement;

	public P3_CorrectLeft(UltrasonicSensor sonic, int speed, int rotationSpeed, int min_dist, LightSensor light, Movement movement) {
		this.movement = movement;
		this.sonic = sonic;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.min_dist = min_dist;
		this.light = light;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() <= min_dist) && light.getNormalizedLightValue() < P3_Behavior.threshold;
	}
	
	public void action() {
		suppressed = false;
		movement.steer(25);
		while(!suppressed) {
			Thread.yield();
		}
		movement.stop();
	}
	
	public void suppress() {
		suppressed = true;
	}
	

	

}
