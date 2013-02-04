package p3_LineFollowerDeprecated;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;


public class P3_SearchLine implements Behavior{
	int threshold;
	LightSensor light;
	boolean suppressed;
	int searchDegree = 10;
	Movement movement;
	
	public P3_SearchLine(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
		this.threshold = P3.threshold;
	}
	
	@Override
	public boolean takeControl() {
		int lightvalue = light.getNormalizedLightValue(); 
		return (lightvalue < threshold) && P3.foundLineForFirstTime && P3.search;
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Searching a Line", 1, 1);
		
		suppressed = false;
		searchDegree = 10;
		int i = 0;
		movement.setSpeed(1);
		while (searchDegree <= 110 && !suppressed && light.getNormalizedLightValue() < threshold) { 
			LCD.clear();
			LCD.drawInt(light.getNormalizedLightValue() , 1, 1);
			if (!suppressed)
				movement.turn_right(searchDegree);
			while(movement.isMoving()); 
			if (!suppressed)
				movement.turn_left(2*searchDegree);
			while(movement.isMoving());
			if (!suppressed)
				movement.turn_right(searchDegree);
			LCD.drawString("Degree: " + searchDegree, 1,2);
			searchDegree = searchDegree + 20 + i*20;
			if (searchDegree > 110) {
				P3.numberOfSearches++;
				P3.search = false;
			}	
		}
		i++;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
