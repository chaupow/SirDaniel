package general;
import java.util.Arrays;

import lejos.nxt.LCD;
import lejos.util.Delay;


public class Settings {
	
	// Constants
	private static final int LIGHT_CALIBRATION_SAMPLES = 500;
	
	//Calibartion Flags hier rein
	//initRace, ...
	//reset
	/**Flag race**/
	public static boolean race = false;
	/**Flag bridge**/
	public static boolean bridge = false;
	/**Flag labyrinth**/
	public static boolean labyrinth = false;
	/**Flag swamp**/	
	public static boolean swamp = false;
	/**Flag bluetooth**/
	public static boolean bluetooth = false;
	/**Flag turntable**/
	public static boolean turntable = false;
	/**Flag slider**/
	public static boolean slider = false;
	/**Flag rocker**/
	public static boolean rocker = false;
	/**Flag plnak_bridge**/
	public static boolean plank_bridge = false;
	/**Flag linefollow**/
	public static boolean linefollow = false;
	/**Flag colors**/
	public static boolean colors = false;
	/**Flag boss**/
	public static boolean boss = false;
	
	
	public static void initRace() {
		SuperMotor.turnTo(0, false);
	}
	
	public static void initBridge() {
		SuperMotor.turnTo(180, false);
	}
	
	public static void initLabyrinth(){
		SuperMotor.turnTo(0, false);
	}
	
	public static void initSwamp(){
		SuperMotor.turnTo(0, false);
	}
	
	public static void initBluetooth(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initTurntable(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initSlider(){
		
		Movement.getInstance().travel(150);
		SuperMotor.turnTo(0, false);
	}
	
	public static void initRocker(){
		SuperMotor.turnTo(90, false);
	}
	
	
	public static void initPlankBridge(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initLineFollow(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initColors(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initBoss(){
		SuperMotor.turnTo(0, false);
	}
	
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
			
		LCD.drawString("Light: "+ lowAvg + " " + highAvg, 0, 0);
		
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

