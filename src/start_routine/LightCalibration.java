package start_routine;

import general.SensorCache;
import java.util.Arrays;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class LightCalibration implements Behavior {
	
	private final int SAMPLES = 500;
	private boolean hasBeenCalled = false;
	
	private int[] lightValues = new int[SAMPLES];
	private int lightValuesCounter = 0;

	@Override
	public boolean takeControl() {
		boolean finishedCollecting = lightValuesCounter >= SAMPLES;
		
		if (!finishedCollecting) {
			lightValues[lightValuesCounter] = SensorCache.getInstance().normalizedLightValue;
			lightValuesCounter++;
		}
		return (finishedCollecting && !hasBeenCalled);
	}

	@Override
	public void action() {
		Arrays.sort(lightValues);
		
		int lowAvg = getAverage(50,100);
		SensorCache.getInstance().light.setLow(lowAvg);
		
		int highAvg = getAverage(400,450);
		SensorCache.getInstance().light.setHigh(highAvg);
		
		LCD.drawString("Light: "+ lowAvg + " " + highAvg, 0, 0);
		
		hasBeenCalled = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	private int getAverage(int from, int to) {
		assert(to > from);
		int average = 0;
		for (int i = from; i < to; i++) {
			average += lightValues[i];
		}
		average /= to - from;
		return average;
	}
	
	
}
