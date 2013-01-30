import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;


public class P3FollowLine implements Behavior {
	LightSensor light;
	int threshold;
	boolean suppressed;

	public P3FollowLine(LightSensor light) {
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
		if (P3.numberOfSearches == 3) {
			P3.search = true;
		}
		P3.numberOfSearches = 0;
		suppressed = false;
		LCD.clear();
		LCD.drawString("Following a line", 1, 1);
		Movement.forward(2);
		while (!suppressed) {
			if (light.getNormalizedLightValue() < threshold)
				break;
			Thread.yield();
		}
		Movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
