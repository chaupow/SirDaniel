import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;


public class P3_FollowLine implements Behavior {
	LightSensor light;
	int threshold;
	boolean suppressed;
	Movement movement;

	public P3_FollowLine(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
		this.threshold = P3.threshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue();
		return (lightvalue >= threshold) && !P3.end;
	}

	@Override
	public void action() {
		P3.search = true;
		P3.numberOfSearches = 0;
		suppressed = false;
		
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Following a line", 1, 1);
		
		movement.setSpeed(2);
		movement.forward();
		while (!suppressed) {
			if (light.getNormalizedLightValue() < threshold)
				break;
			Thread.yield();
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
