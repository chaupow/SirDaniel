import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;


public class FollowLine implements Behavior {
	LightSensor light;
	int threshold;
	boolean suppressed;

	public FollowLine(SensorPort s, int threshold) {
		this.light = new LightSensor(s);
		this.threshold = threshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue();
		return lightvalue >= threshold;
	}

	@Override
	public void action() {
		suppressed = false;
		LCD.drawString("Following a line", 1, 1);
		Movement.forward(1);
		while (!suppressed) {
			Thread.yield();
		}
		Movement.stop();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
