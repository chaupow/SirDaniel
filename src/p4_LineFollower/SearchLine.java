package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;

public class SearchLine implements Behavior {
	Movement movement;
	int threshold;
	boolean suppressed;
	SuperMotor supmoto = new SuperMotor();
	
	public SearchLine() {
		this.movement = Movement.getInstance();
		this.threshold = Config.lightThreshold;
	}
	
	@Override
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch && !Config.foundEnd;
	}
	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("SearchLine", 1, 1);
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		suppressed = false;
		int [] degrees = {10, 20, 90};
		int i = 0;
		while (i < degrees.length && (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch) {
			if (suppressed) {
				break;
			}
			if (!suppressed) {
				LCD.clear();
				LCD.drawString( degrees[i]+" Degrees", 1, 2);
				//supmoto.turnTo(90-degrees[i], true);
				movement.rotate(degrees[i], true);
			}
			while(movement.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){Thread.yield();};
			if (!suppressed) {
				LCD.clear();
				LCD.drawString(2*degrees[i]+" Degrees", 1, 2);
				//supmoto.turnTo(90+degrees[i], true);
				movement.rotate(-2*degrees[i], true);
			}
			while(movement.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){Thread.yield();};
			if (!suppressed) {
				LCD.clear();
				LCD.drawString( degrees[i]+" Degrees", 1, 2);
				//supmoto.turnTo(90-degrees[i], true);
				movement.rotate(degrees[i], true);
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
