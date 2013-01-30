import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;


public class SearchLine implements Behavior{
	int threshold;
	LightSensor light;
	boolean suppressed;
	int searchDegree = 10;
	
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
		suppressed = false;
		searchDegree = 10;
		boolean finished = false;
		while (searchDegree < 110 && !suppressed && light.getNormalizedLightValue() < threshold) { //eigentlich while i < 100
			LCD.clear();
			LCD.drawInt(light.getNormalizedLightValue() , 1, 1);
			
			Movement.turn_left(searchDegree);
			//Thread.yield();
			if (light.getNormalizedLightValue() >= threshold)
				break;
			
			Movement.turn_right(2*searchDegree);
			//Thread.yield();
			if (light.getNormalizedLightValue() >= threshold)
				break;
			
			Movement.turn_left(searchDegree);
			//Thread.yield();
			if (light.getNormalizedLightValue() >= threshold)
				break;
			searchDegree += 20;
		}
		if (searchDegree == 110) {
			LineFollower.finishedSearch = true;
		}
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
