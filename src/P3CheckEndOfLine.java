import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3CheckEndOfLine implements Behavior{

	LightSensor light;
	
	public P3CheckEndOfLine(LightSensor light) {
		this.light = light;
	}
	
	@Override
	public boolean takeControl() {
		return (P3.numberOfSearches == 2) && !P3.end;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Checking end of Line", 1, 1);
		Movement.backward(1);
		Delay.msDelay(1500);
		LCD.drawString("Moved backwards", 1, 2);
		Movement.stop();
		if (light.getNormalizedLightValue() >= P3.threshold) {
			P3.end = true;
		}
		else
			P3.search = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
