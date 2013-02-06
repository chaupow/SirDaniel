package general;

import java.util.Arrays;

import lejos.util.Delay;


public class Settings {
	
	// Constants
	private static final int LIGHT_CALIBRATION_SAMPLES = 500;
	
	//Calibartion Flags hier rein
	//initRace, ...
	//reset
	public enum State {race, bridge, labyrinth, swamp, gate, turntable, slider, line, rocker, colorGate, boss};
	public static int LIGHT_THRESHOLD = 450;
	
	public static void calibrateLight(){
		int[] lightValues = new int[LIGHT_CALIBRATION_SAMPLES];
		
		Movement.getInstance().setTravelSpeed(50);
		Movement.getInstance().forward();
		
		for (int i = 0; i < LIGHT_CALIBRATION_SAMPLES; i++) {
			lightValues[i] = SensorCache.getInstance().light.getNormalizedLightValue();
			Delay.msDelay(10);
		}
		
		Movement.getInstance().stop();
		
		Arrays.sort(lightValues);
			
		int lowAvg = getAverage(50,100,lightValues);
		SensorCache.getInstance().light.setLow(lowAvg);
			
		int highAvg = getAverage(400,450,lightValues);
		SensorCache.getInstance().light.setHigh(highAvg);
			
		System.out.println("Light: "+ lowAvg + " " + highAvg);
		
	}
	
	private static int getAverage(int from, int to, int[] lightValues) {
		assert(to > from);
		int average = 0;
		for (int i = from; i < to; i++) {
			average += lightValues[i];
		}
		average /= to - from;
		return average;
	}
	
}

