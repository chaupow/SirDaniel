package p5_turntable;

import general.SensorCache;
import general.Settings;
import general.SuperMotor;
import lejos.robotics.subsumption.Behavior;

public class BoxEntryDetect implements Behavior{
	int trigger;
	int superMotorRotation;
	
	public BoxEntryDetect (int trigger, int superMotorRotation) {
		this.trigger = trigger;
		this.superMotorRotation = superMotorRotation;
	}
	
	@Override
	public boolean takeControl() {
		return (p4_LineFollower.Config.numberOfSearches == trigger && SensorCache.getInstance().normalizedLightValue < p4_LineFollower.Config.lightThreshold);
	}

	@Override
	public void action() {
		SuperMotor.turnTo(superMotorRotation, false);
		p4_LineFollower.Config.random = true;
	}

	@Override
	public void suppress() {
	}

}
