package p8_colorbuttons;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.robotics.subsumption.Behavior;

public class P8_DriveOverColors implements Behavior{
	boolean suppressed;
	Movement movement = Movement.getInstance();

	@Override
	public boolean takeControl() {
		return SensorCache.getInstance().normalizedLightValue < P8_Config.lightBlackThreshold;
	}

	@Override
	public void action() {
		suppressed = false;
		movement.forward();
		while (!suppressed && SensorCache.getInstance().normalizedLightValue < P8_Config.lightBlackThreshold) {
			Thread.yield();
		}
		movement.stop();
	}
	

	@Override
	public void suppress() {
		suppressed = true;
	}

}
