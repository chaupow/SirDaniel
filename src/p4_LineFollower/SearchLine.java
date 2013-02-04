package p4_LineFollower;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

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
		return (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch && !Config.foundEnd;
	}
	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("SearchLine", 1, 1);
		movement.setTravelSpeed(100);
		movement.setRotateSpeed(100);
		suppressed = false;
		int [] degrees = {10, 45, 90};
		int i = 0;
		while (i < degrees.length && (SensorCache.getInstance().normalizedLightValue < threshold) && !Config.finishedSearch && !suppressed) {
			if (!suppressed) {
				SuperMotor.turnTo(90-degrees[i], true);
			}
			while(Motor.C.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){
				Thread.yield();
			}
			if (!suppressed) {
				SuperMotor.turnTo(90+degrees[i], true);
			}
			while(Motor.C.isMoving() && !suppressed && (SensorCache.getInstance().normalizedLightValue < threshold)){
				Thread.yield();
			}
			i++;
			if (i == (degrees.length-1)) {
				Config.numberOfSearches++;
				Config.finishedSearch = true;
			}	
		}
		int angle = (SuperMotor.getAngleOfArm()-90);
		if (angle != 0 && (new LightSensor(SensorPort.S4).getNormalizedLightValue()) >= Config.lightThreshold) {
			LCD.clear();
			LCD.drawString("Correcting myself", 1, 1);
			
			SuperMotor.turnTo(90, false);
			int radius = 40;
			if (angle < 0 ) {
				radius = -1*radius;
			}	
			movement.arc(radius, angle);
		}
		if (SuperMotor.getAngleOfArm() != 90)
			SuperMotor.turnTo(90, false);
	}
	@Override
	public void suppress() {
		suppressed = true;
	}
	

}
