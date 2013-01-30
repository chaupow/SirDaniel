import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3CheckGap implements Behavior{
	LightSensor light;
	
	public P3CheckGap(SensorPort s) {
		this.light = new LightSensor(s);
	}

	@Override
	public boolean takeControl() {
		return (P3.numberOfSearches == 1) && !P3.stop && !P3.search && !P3.end;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Checking Gap", 1, 1);
		Movement.forward(1);
		Delay.msDelay(1000);
		Movement.stop();
		P3.search = true;;
	}

	@Override
	public void suppress() {
		
	}

}
