package p4_LineFollower;

import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class RandomDetect implements Behavior{
	int trigger;
	
	public RandomDetect (int trigger) {
		this.trigger = trigger;
	}
	
	@Override
	public boolean takeControl() {
		return Config.numberOfSearches == trigger && SensorCache.getInstance().normalizedLightValue < Config.lightThreshold;
	}

	@Override
	public void action() {
		Config.random = true;
	}

	@Override
	public void suppress() {
	}

}
