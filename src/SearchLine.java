import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;


public class SearchLine implements Behavior{
	int threshold;
	LightSensor light;
	boolean suppressed;
	
	public SearchLine(SensorPort s, int threshold){
		this.light = new LightSensor(s);
		this.threshold = threshold;
		
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue(); 
		return lightvalue < threshold;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Searching a Line", 1, 1);
		int i = 10;
		suppressed = false;
		/*while (!suppressed) { //eigentlich while i < 100
			Movement.turn_left(i);
			Thread.yield();
			Movement.turn_right(2*i);
			Thread.yield();
			Movement.turn_left(i);
			Thread.yield();
			i += 10;
			
		}
		*/
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
