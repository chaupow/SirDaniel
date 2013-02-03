package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class SearchLine implements Behavior {
	Movement movement;
	int threshold;
	boolean suppressed;
	
	public SearchLine() {
		this.movement = Movement.getInstance();
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch;
	}
	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("SearchLine", 1, 1);
		movement.setTravelSpeed(150);
		movement.setRotateSpeed(150);
		suppressed = false;
		int [] degrees = {5, 10, 90, 110};
		int i = 0;
		while (i < degrees.length && (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch) {
			if (suppressed) {
				break;
			}
			if (!suppressed) {
				LCD.clear();
				LCD.drawString( degrees[i]+" Degrees", 1, 2);
				movement.rotate(-degrees[i], true);
			}
			while(movement.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){Thread.yield();};
			if (!suppressed) {
				LCD.clear();
				LCD.drawString(2*degrees[i]+" Degrees", 1, 2);
				movement.rotate(2* degrees[i], true);
			}
			while(movement.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){Thread.yield();};
			if (!suppressed) {
				LCD.clear();
				LCD.drawString( degrees[i]+" Degrees", 1, 2);
				movement.rotate(-degrees[i], true);
			}
			while(movement.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){Thread.yield();};
			i++;
			if (i == (degrees.length-1)) {
				Config.numberOfSearches++;
				Config.finishedSearch = true;
			}
		}
	}
	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
