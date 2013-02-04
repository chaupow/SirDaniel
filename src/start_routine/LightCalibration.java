package start_routine;

import general.SensorCache;

import java.util.Arrays;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class LightCalibration implements Behavior {
	
	private final int NUMBER_OF_LIGHT_VALUES = 200;
	private boolean hasBeenCalled = false;
	
	private int[] lightValues = new int[200];
	private int lightValuesCounter = 0;
	
	private LightSensor light = new LightSensor(SensorPort.S4);

	@Override
	public boolean takeControl() {
		boolean finishedCollecting = lightValuesCounter >= NUMBER_OF_LIGHT_VALUES;
		
		if (!finishedCollecting) {
			lightValues[lightValuesCounter] = SensorCache.getInstance().normalizedLightValue;
			lightValuesCounter++;
		}
		return (finishedCollecting && !hasBeenCalled);
	}

	@Override
	public void action() {
		Arrays.sort(lightValues);
		
		int lowAvg = getAverage(10,20);
		light.setLow(lowAvg);
		
		int highAvg = getAverage(180,190);
		light.setHigh(highAvg);
		
		System.out.println("Light: "+ lowAvg + " " + highAvg);
		
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
