import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3SearchLine implements Behavior{
	int threshold;
	LightSensor light;
	boolean suppressed;
	int searchDegree = 10;
	
	public P3SearchLine(LightSensor light){
		this.light = light;
		this.threshold = P3.threshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue(); 
		return (lightvalue < threshold) && P3.foundLineForFirstTime && !P3.stop && !P3.end && P3.search;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Searching a Line", 1, 1);
		suppressed = false;
		searchDegree = 10;
		
		while (searchDegree <= 110 && !suppressed && light.getNormalizedLightValue() < threshold) { 
			LCD.clear();
			LCD.drawInt(light.getNormalizedLightValue() , 1, 1);
			if (!suppressed)
				Movement.turn_right(searchDegree, 1);
			while(Movement.isMoving()); 
			if (!suppressed)
				Movement.turn_left(2*searchDegree, 1);
			while(Movement.isMoving());
			if (!suppressed)
				Movement.turn_right(searchDegree, 1);
			searchDegree += 20;
		}
		if (searchDegree == 110) {
			P3.numberOfSearches++;
			P3.search = false;
		}	
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
